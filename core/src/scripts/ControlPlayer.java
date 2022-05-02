package scripts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import scripts.classes.Force;
import scripts.classes.GameCharacter;
import scripts.classes.Vector3;

public abstract class ControlPlayer {




    public static GameCharacter player;


    private static Force f;

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
        if(!player.getPhysic3().checkForForceInForceListID(-1,player.getId()))
        {
            f = new Force(currentMovement,-1, player.getId());
            player.getPhysic3().addToForceList(f);
        }
        else
        {
            f.setDirectionVector3(currentMovement.copied());
        }
    }
}
