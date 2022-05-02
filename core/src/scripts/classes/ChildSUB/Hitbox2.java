package scripts.classes.ChildSUB;

import scripts.classes.*;
import scripts.classes.GameCharacter;

import java.util.ArrayList;
import java.util.List;

import static scripts.classes.PhysicHandler.hitbox2List;

public class Hitbox2 extends Child {
    public Hitbox2(GameCharacter parent, ChildPositionHandler positionHandler, Vector3 bounds) {
        super(parent,positionHandler);
        checked = false;
        this.parent = parent;
        hitbox2List.add(this);
        setBounds(bounds);
        activated = true;
        this.physic2 = parent.getPhysic2();
        collisionList = new ArrayList<>();

    }
    public Hitbox2(Vector3 bounds)
    {
        setBounds(bounds);
    }




    public boolean checked;

    public boolean activated;

    private Vector3 bounds;

    public Vector3 getBounds(){return bounds;}
    public void setBounds (Vector3 bounds){

        this.bounds = bounds;

    }
    public Vector3 getBoundsNegative(){return new Vector3(-bounds.x,-bounds.y);}

    public Vector3 getBoundsGlobal(){return bounds.added(getPosition());}

    public Vector3 getBoundsGlobalNegative(){return getBoundsNegative().added(getPosition());}

    public float getBoundsDiagonale(){
        return (float)Math.sqrt((bounds.x+Math.abs(getBoundsNegative().x))*(bounds.x+Math.abs(getBoundsNegative().x))+(bounds.y+Math.abs(getBoundsNegative().y))*(bounds.y+Math.abs(getBoundsNegative().y)));
    }
    public Vector3 getTotalBounds(){
        return new Vector3((bounds.x+Math.abs(getBoundsNegative().x)),(bounds.y+Math.abs(getBoundsNegative().y)));
    }





    public Physic2 physic2;

    public List<Collision> collisionList;




















    public void onCollision(Collision collision) {
        boolean foundCollision = false;
        int index = 0;
        for (int c1 = 0; c1 < collisionList.size(); c1++) {
            if (collision.colliderPrimary == collisionList.get(c1).colliderPrimary && collision.colliderSecondary == collisionList.get(c1).colliderSecondary) {
                foundCollision = true;
                index = c1;
                collisionList.set(c1,collision);
            }
        }
        if (!foundCollision)
        {
            collisionList.add(collision);
            onCollisionEnter(collision);
        }
        else
        {
            collisionList.get(index).setRefreshedThisCycle(true);
            onCollisionStay(collision);
        }
    }
    public void onCollisionEnter(Collision collision) {
        //System.out.println("behold, CollisionEnter!");
    }

    public void onCollisionStay(Collision collision) {
        //System.out.println("behold, CollisionStay!");
    }

    public void onCollisionExit(Collision collision) {
        collisionList.remove(collision);
       // System.out.println("behold, CollisionExit!");
    }







    public boolean overlapsHitbox(Vector3 h2Bounds, Vector3 h2BoundsNegative)
    {
        if ((getBoundsGlobal().x >= h2BoundsNegative.x && getBoundsGlobal().y >= h2BoundsNegative.y)//check h1>h2
                && ( getBoundsGlobalNegative().x <= h2Bounds.x && getBoundsGlobalNegative().y <= h2Bounds.y))//check h1<h2
        {
            return  true;
        }
        return  false;
    }
    public boolean overlapsHitboxOffset(Vector3 h2Bounds, Vector3 h2BoundsNegative, Vector3 offset)
    {
        if ((getBoundsGlobal().added(offset).x >= h2BoundsNegative.x && getBoundsGlobal().added(offset).y >= h2BoundsNegative.y)//check h1>h2
                && ( getBoundsGlobalNegative().added(offset).x <= h2Bounds.x && getBoundsGlobalNegative().added(offset).y <= h2Bounds.y))//check h1<h2
        {
            return  true;
        }
        return  false;
    }
}
