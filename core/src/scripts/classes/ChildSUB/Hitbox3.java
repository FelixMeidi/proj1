package scripts.classes.ChildSUB;

import scripts.classes.*;
import scripts.classes.GameCharacter;

import java.util.ArrayList;
import java.util.List;

import static scripts.classes.PhysicHandler.hitbox3List;

public class Hitbox3 extends Child
{
    public Hitbox3(GameCharacter parent, ChildPositionHandler positionHandler, Vector3 bounds, Vector3 boundsNegative)
    {
        super(parent, positionHandler);
        checked = false;
        this.parent = parent;
        hitbox3List.add(this);
        setBounds(bounds);
        setBoundsNegative(boundsNegative);
        activated = true;
        this.physic3 = parent.getPhysic2();
        collisionList = new ArrayList<>();
    }
    public Hitbox3(GameCharacter parent,Vector3 bounds, Vector3 boundsNegative)
    {
        super(parent, new ChildPositionHandler());
        checked = false;
        this.parent = parent;
        hitbox3List.add(this);
        setBounds(bounds);
        setBoundsNegative(boundsNegative);
        activated = true;
        this.physic3 = parent.getPhysic2();
        collisionList = new ArrayList<>();
    }


    public boolean checked;

    public boolean activated;

    private Vector3 bounds;

    private Vector3 boundsNegative;

    public Vector3 getBounds()
    {
        return bounds.copied();
    }

    public void setBounds(Vector3 bounds)
    {
        this.bounds = bounds;
    }

    public void setBoundsNegative(Vector3 boundsNegative)
    {
        this.boundsNegative = boundsNegative;
    }

    public Vector3 getBoundsNegative()
    {
        return boundsNegative.copied();
    }

    public Vector3 getBoundsGlobal()
    {
        return bounds.added(getPosition());
    }

    public Vector3 getBoundsGlobalNegative()
    {
        return getBoundsNegative().added(getPosition());
    }


    public Physic3 physic3;

    public List<Collision> collisionList;


    public void onCollision(Collision collision)
    {
        boolean foundCollision = false;
        int index = 0;
        for (int c1 = 0; c1 < collisionList.size(); c1++)
        {
            if (collision.colliderPrimary == collisionList.get(c1).colliderPrimary && collision.colliderSecondary == collisionList.get(c1).colliderSecondary)
            {
                foundCollision = true;
                index = c1;
                collisionList.set(c1, collision);
            }
        }
        if (!foundCollision)
        {
            collisionList.add(collision);
            onCollisionEnter(collision);
        } else
        {
            collisionList.get(index).setRefreshedThisCycle(true);
            onCollisionStay(collision);
        }
    }

    public void onCollisionEnter(Collision collision)
    {
        //System.out.println("behold, CollisionEnter!");
    }

    public void onCollisionStay(Collision collision)
    {
        //System.out.println("behold, CollisionStay!");
    }

    public void onCollisionExit(Collision collision)
    {
        collisionList.remove(collision);
        // System.out.println("behold, CollisionExit!");
    }


    public boolean overlapsHitboxOffset(Vector3 h2Bounds, Vector3 h2BoundsNegative, Vector3 offset)
    {
        if (
                (
                        getBoundsGlobal().added(offset).x > h2BoundsNegative.x
                                &&
                                getBoundsGlobalNegative().added(offset).x < h2Bounds.x
                )
                        &&
                        (
                                getBoundsGlobal().added(offset).y > h2BoundsNegative.y
                                        &&
                                        getBoundsGlobalNegative().added(offset).y < h2Bounds.y
                        )
                        &&
                        (
                                getBoundsGlobal().added(offset).z > h2BoundsNegative.z
                                        &&
                                        getBoundsGlobalNegative().added(offset).z < h2Bounds.z
                        )
        )
        {
            return true;
        }
        return false;
    }
}
