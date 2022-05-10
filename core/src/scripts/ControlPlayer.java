package scripts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import scripts.classes.GameCharacter;
import scripts.classes.Vector3;

public abstract class ControlPlayer {




    public static GameCharacter player;




    public static void getInputs()
    {
        Vector3 currentMovement = new Vector3();
        if(Gdx.input.isKeyPressed(Input.Keys.D))
        {
            currentMovement.x+=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            currentMovement.x-=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            currentMovement.z-=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S))
        {
            currentMovement.z+=1;
        }
        currentMovement = currentMovement.multiplied(1);
        Vector3 newvel = player.getPhysic2().getVelocity().copied();
        newvel.x = currentMovement.x;
        newvel.z = currentMovement.z;
        player.getPhysic2().setVelocity(newvel);
    }
}
