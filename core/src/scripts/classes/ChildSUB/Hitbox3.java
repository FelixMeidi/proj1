package scripts.classes.ChildSUB;

import scripts.classes.*;
import scripts.classes.GameCharacter;

import java.util.ArrayList;
import java.util.List;

import static scripts.classes.PhysicHandler.hitbox3List;

public class Hitbox3 extends Child {
    public Hitbox3(GameCharacter parent, ChildPositionHandler positionHandler, Vector3 bounds, Vector3 boundsNegative) {
        super(parent,positionHandler);
        autoInit(false,parent,bounds,boundsNegative,true,parent.getPhysic3());
    }

    public void autoInit(boolean checked, GameCharacter parent,Vector3 bounds,Vector3 boundsNegative,boolean activated, Physic3 phy)
    {
        hitbox3List.add(this);
        this.checked = checked;
        this.parent = parent;
        setBounds(bounds,boundsNegative);
        this.activated = activated;
        this.physic3 = phy;
        collisionList = new ArrayList<>();
    }




    public boolean checked;

    public boolean activated;

    private Vector3 bounds;
    private Vector3 boundsNegative;

    public Vector3 getBounds(){return bounds;}
    public void setBounds (Vector3 bounds,Vector3 boundsNegative){

        this.bounds = bounds;
        this.boundsNegative = boundsNegative;
    }
    public Vector3 getBoundsNegative(){return boundsNegative.copied();}

    public Vector3 getBoundsGlobal(){return bounds.added(getPosition());}

    public Vector3 getBoundsGlobalNegative(){return getBoundsNegative().added(getPosition());}





    public Physic3 physic3;

    public List<Collision> collisionList;



















/*
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
*/







    public boolean overlapsHitboxOffset(Vector3 h2Bounds, Vector3 h2BoundsNegative, Vector3 offset)
    {
        if ((getBoundsGlobal().added(offset).x > h2BoundsNegative.x && getBoundsGlobal().added(offset).y > h2BoundsNegative.y)//check h1>h2
                && ( getBoundsGlobalNegative().added(offset).y < h2Bounds.y && getBoundsGlobalNegative().added(offset).y < h2Bounds.y)
            && ( getBoundsGlobalNegative().added(offset).z < h2Bounds.z && getBoundsGlobalNegative().added(offset).z < h2Bounds.z))//check h1<h2
        {
            return  true;
        }
        return  false;
    }
/*
    public boolean overlapsHitboxOffset(Vector3 h2Bounds, Vector3 h2BoundsNegative, Vector3 offset)
    {
        if ((getBoundsGlobal().added(offset).x >= h2BoundsNegative.x && getBoundsGlobal().added(offset).y >= h2BoundsNegative.y)//check h1>h2
                && ( getBoundsGlobalNegative().added(offset).y <= h2Bounds.y && getBoundsGlobalNegative().added(offset).y <= h2Bounds.y)
                && ( getBoundsGlobalNegative().added(offset).z <= h2Bounds.z && getBoundsGlobalNegative().added(offset).z <= h2Bounds.z))//check h1<h2
        {
            return  true;
        }
        return  false;
    }*/
    public Vector3 calculateNewVelocity(Vector3 v1,Vector3 v2,Vector3 pos1,Vector3 pos2)
    {
        Vector3 newVector = v1.copied();
        Vector3 diff = pos2.subbed(pos1);
        diff.x = Math.abs(diff.x);
        diff.y = Math.abs(diff.y);
        diff.z = Math.abs(diff.z);
        if(diff.x>=diff.y&&diff.x>=diff.z)
        {
            newVector.x = 0;
        }
        else if(diff.y>=diff.x&&diff.y>=diff.z)
        {
            newVector.y = 0;
        }
        else
        {
            newVector.z = 0;
        }
        return newVector;
    }
}
