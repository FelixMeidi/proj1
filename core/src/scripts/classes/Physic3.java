package scripts.classes;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public class Physic3 extends Child{

    public static ArrayList<Physic3> physic3List = new ArrayList<>();



    //region constructors
    public Physic3(boolean fixed, boolean infiniteWeight, float weight){
        super();
        this.gameCharacter = parent;
        velocity = new Vector3();
        this.fixed = fixed;
        this.infiniteWeight = infiniteWeight;
        this.weight = weight;
        physic3List.add(this);
    }
    private GameCharacter gameCharacter;
    public boolean fixed;
    public boolean infiniteWeight;
    private Vector3 velocity;
    public Vector3 getVelocity(){return new Vector3(velocity.x, velocity.y, velocity.z);}
    public void setVelocity(Vector3 targetVelocity){velocity = targetVelocity;}

    private float weight;
    public float getWeight(){return weight;}



    public void handleVelocity()
    {
        gameCharacter.setPosition(gameCharacter.getPosition().added(getVelocity().multiplied(Gdx.graphics.getDeltaTime()).multiplied(100)));
        velocity.reset();
    }
}