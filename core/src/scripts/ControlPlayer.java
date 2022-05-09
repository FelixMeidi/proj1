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
            currentMovement.y+=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S))
        {
            currentMovement.y-=1;
        }
        currentMovement = currentMovement.multiplied(1);
        player.getPhysic2().setVelocityX(currentMovement.x);
        if(currentMovement.x != 0||currentMovement.y!=0)
        {
            System.out.println("");
        }
    }
}
