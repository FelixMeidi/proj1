package scripts.classes;

import com.badlogic.gdx.Gdx;
import scripts.classes.ChildSUB.Hitbox3;

public class Physic3 {
    //region constructors
    public Physic3(GameCharacter gameCharacter, boolean fixed, boolean infiniteWeight, float weight){
        this.gameCharacter = gameCharacter;
        velocity = new Vector3();
        this.fixed = fixed;
        this.infiniteWeight = infiniteWeight;
        this.weight = weight;
    }
    public Hitbox3 hitbox3;
    private GameCharacter gameCharacter;
    public boolean fixed;
    public boolean infiniteWeight;
    private Vector3 velocity;
    public Vector3 getVelocity(){return new Vector3(velocity.x, velocity.y, velocity.z);}
    public void setVelocity(Vector3 targetVelocity){velocity = targetVelocity;}
    public void setVelocityX(float targetVelocityX){velocity.x = targetVelocityX;}

    private float weight;
    public float getWeight(){return weight;}



    public void handleVelocity()
    {
        gameCharacter.setPosition(gameCharacter.getPosition().added(getVelocity().multiplied(Gdx.graphics.getDeltaTime()).multiplied(100)));
        velocity.reset();
    }
}