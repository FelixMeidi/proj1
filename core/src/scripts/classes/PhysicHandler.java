package scripts.classes;

import scripts.classes.ChildSUB.Hitbox3;

import java.util.ArrayList;
import java.util.List;

public /*static*/ final class PhysicHandler
{
    private PhysicHandler() {}




    public static List<Hitbox3> hitbox3List = new ArrayList<>();






    public static void updateHitboxes() {
        //region maincheck
        // go through hitbox list and check for collsions
        for (int c1 = 0; c1 < hitbox3List.size(); c1++) {
            Hitbox3 h1 = hitbox3List.get(c1);
            if (h1.activated&&!h1.checked) {//check next frame, not this!-------
                for (int c2 = 0; c2 < hitbox3List.size(); c2++) {
                    Hitbox3 h2 = hitbox3List.get(c2);
                    if (h2.activated&&!h2.checked) {
                        if (c1 != c2) {
                            //calculate offset
                            int c3 = 0;
                            Vector3 offset;
                            float velocitySum = h1.physic3.getVelocity().sum()/100;
                            boolean collisionFound = false;
                            do{
                                offset = h1.physic3.getVelocity().zeroOrOned().multiplied(c3);
                                if (h1.overlapsHitboxOffset(h2.getBoundsGlobal(), h2.getBoundsGlobalNegative(),offset)) {
                                    h1.onCollision(new Collision(h1, h2));
                                    h2.onCollision(new Collision(h2, h1));
                                    Vector3 newVelocity1 = new Vector3();
                                    Vector3 newVelocity2 = new Vector3();
                                    if(!h1.physic3.infiniteWeight&&!h2.physic3.infiniteWeight)
                                    {
                                        newVelocity1 = calculateNewVelocity(h1.physic3.getVelocity(), h2.physic3.getVelocity(), h1, h2, h1.physic3.getWeight(), h2.physic3.getWeight());

                                        newVelocity2 = calculateNewVelocity(h2.physic3.getVelocity(), h1.physic3.getVelocity(), h2, h1, h2.physic3.getWeight(), h1.physic3.getWeight());
                                    }
                                    else if(h2.physic3.infiniteWeight)
                                    {
                                        newVelocity1 = calculateNewVelocity(h1.physic3.getVelocity(),h1,h2);
                                    }
                                    else if(h1.physic3.infiniteWeight)
                                    {
                                        newVelocity2 = calculateNewVelocity(h2.physic3.getVelocity(),h2,h1);
                                    }
                                    h1.physic3.setVelocity(newVelocity1);
                                    h2.physic3.setVelocity(newVelocity2);
/*

                                    if(c3>2)//calculate polished offset and position
                                    {
                                        Vector3 accurateOffset = new Vector3();
                                        float addition = 0;
                                        do {
                                            accurateOffset = accurateOffset.added(h1.physic3.getVelocity().zeroOrOned().multiplied(addition));
                                            addition++;
                                        }while(!h1.overlapsHitboxOffset(h2.getBoundsGlobal(), h2.getBoundsGlobalNegative(),accurateOffset));
                                        Vector3 setback = h1.physic3.getVelocity().zeroOrOned().multiplied(addition);
                                        setback = setback.multiplied(0);
                                        accurateOffset = accurateOffset.subbed(setback);
                                      //  h1.parent.addToPosition(accurateOffset);
                                    }
                                    collisionFound = true;*/
                                }
                                c3++;

                            }while(velocitySum > offset.valued().sum()/2/*&&!collisionFound*/);
                        }
                    }
                }
            }
            h1.checked = true;
        }
        //endregion
        //region secondary
        //reset "checked" and check for onCollsionsExit
        for (int c1 = 0; c1 < hitbox3List.size(); c1++) {
            Hitbox3 h = hitbox3List.get(c1);
            h.checked = false;

            for (int c4 = 0; c4 < h.collisionList.size(); c4++)
            {

                Collision c = h.collisionList.get(c4);
                if (!c.getRefreshedThisCycle() && c != null)
                {
                    h.collisionList.remove(c4);
                    h.onCollisionExit(c);

                    c4 = 0;
                }
                else
                {
                    c.setRefreshedThisCycle(false);
                }
            }
        }
        //endregion
    }
    public static void applyVelocities()
    {
        for (int c1 = 0; c1 < GameCharacter.gameCharacterList.size(); c1++) {
            Physic3 phy = GameCharacter.gameCharacterList.get(c1).physic3;
            if(!phy.fixed)
            {
                phy.handleVelocity();
            }
        }
    }
    public static void setGravityVelocity()
    {
        for (int c1 = 0; c1 < GameCharacter.gameCharacterList.size(); c1++) {
            Physic3 phy2 = GameCharacter.gameCharacterList.get(c1).getPhysic2();
            phy2.setVelocity(new Vector3(phy2.getVelocity().added(new Vector3(0,-0.2f,0))));
        }
    }

    public static Vector3 calculateNewVelocity(Vector3 v,Vector3 v2, Hitbox3 h1, Hitbox3 h2, float weight1, float weight2)
    {
        Vector3 posDiff = new Vector3(h2.boundsMiddlePoint().added(h2.getPosition()).subbed(h1.boundsMiddlePoint().added(h1.getPosition())));
        Vector3 boundsCombined = new Vector3(h2.centeredBounds().absd().added(h1.centeredBounds().absd()));
        Vector3 endDiff = posDiff.absd().subbed(boundsCombined);
        Vector3 endDiffABS = endDiff.absd();
        if(endDiffABS.x<endDiffABS.y&&endDiffABS.x<endDiffABS.z)
        {
            v.x = (v.x * weight1 + v2.x * weight2) / (weight1 + weight2);
        }
        if(endDiffABS.y<endDiffABS.x&&endDiffABS.y<endDiffABS.z)
        {
            v.y = (v.y * weight1 + v2.y * weight2) / (weight1 + weight2);
        }
        if(endDiffABS.z<endDiffABS.x&&endDiffABS.z<endDiffABS.y)
        {
            v.y = (v.y * weight1 + v2.y * weight2) / (weight1 + weight2);
        }
        return  v;
    }

    public static Vector3 calculateNewVelocity(Vector3 v, Hitbox3 h1, Hitbox3 h2)
    {
        Vector3 posDiff = new Vector3(h2.boundsMiddlePoint().added(h2.getPosition()).subbed(h1.boundsMiddlePoint().added(h1.getPosition())));
        Vector3 boundsCombined = new Vector3(h2.centeredBounds().absd().added(h1.centeredBounds().absd()));
        Vector3 endDiff = posDiff.absd().subbed(boundsCombined);
        Vector3 endDiffABS = endDiff.absd();
        if(endDiffABS.x<endDiffABS.y&&endDiffABS.x<endDiffABS.z)
        {
            v.x = 0;
        }
        if(endDiffABS.y<endDiffABS.x&&endDiffABS.y<endDiffABS.z)
        {
            v.y = 0;
        }
        if(endDiffABS.z<endDiffABS.x&&endDiffABS.z<endDiffABS.y)
        {
            v.z = 0;
        }
        return  v;
    }
}
