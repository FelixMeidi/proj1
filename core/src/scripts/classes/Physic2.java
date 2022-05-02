package scripts.classes;

import com.badlogic.gdx.Gdx;
import scripts.classes.ChildSUB.Hitbox2;

public class Physic2{
    //region constructors
    public Physic2(GameCharacter gameCharacter, boolean fixed, boolean infiniteWeight, float weight){
        this.gameCharacter = gameCharacter;
        velocity = new Vector2();
        this.fixed = fixed;
        this.infiniteWeight = infiniteWeight;
        this.weight = weight;
    }
    public Hitbox2 hitbox2;
    private GameCharacter gameCharacter;
    public boolean fixed;
    public boolean infiniteWeight;
    private Vector2 velocity;
    public Vector2 getVelocity(){return new Vector2(velocity.x, velocity.y);}
    public void setVelocity(Vector2 targetVelocity){velocity = targetVelocity;}
    public void setVelocityX(float targetVelocityX){velocity.x = targetVelocityX;}

    private float weight;
    public float getWeight(){return weight;}



    public void handleVelocity()
    {
        gameCharacter.setPosition(gameCharacter.getPositon().added(getVelocity().multiplied(Gdx.graphics.getDeltaTime()).multiplied(100)));
        velocity.reset();
    }
}