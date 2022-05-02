package scripts.classes;

import scripts.classes.ChildSUB.Hitbox2;

import java.util.ArrayList;
import java.util.List;

public /*static*/ final class PhysicHandler
{
    private PhysicHandler() {}




    public static List<Hitbox2> hitbox2List = new ArrayList<>();






    public static void updateHitboxes() {
        //region maincheck
        // go through hitbox list and check for collsions
        for (int c1 = 0; c1 < hitbox2List.size(); c1++) {
            Hitbox2 h1 = hitbox2List.get(c1);
            if (h1.activated&&!h1.checked) {//check next frame, not this!-------
                for (int c2 = 0; c2 < hitbox2List.size(); c2++) {
                    Hitbox2 h2 =hitbox2List.get(c2);
                    if (h2.activated&&!h2.checked) {
                        if (c1 != c2) {
                            //calculate offset
                            int c3 = 1;
                            Vector3 offset;
                            float velocitySum = h1.physic2.getVelocity().sum()/100;
                            boolean collisionFound = false;
                            do{
                                offset = h1.physic2.getVelocity().zeroOrOned().multiplied(c3);
                                if (h1.overlapsHitboxOffset(h2.getBoundsGlobal(), h2.getBoundsGlobalNegative(),offset)) {
                                    h1.onCollision(new Collision(h1, h2));
                                    h2.onCollision(new Collision(h2, h1));

                                    Vector3 newVelocity1 = h1.physic2.getVelocity().calculateNewVelocity(h2.physic2.getVelocity(),h1.getPosition(),h2.getPosition(),h1.physic2.getWeight(),h2.physic2.getWeight());
//
                                    Vector3 newVelocity2 = h2.physic2.getVelocity().calculateNewVelocity(h1.physic2.getVelocity(),h2.getPosition(),h1.getPosition(),h2.physic2.getWeight(),h1.physic2.getWeight());

                                    if(h1.physic2.infiniteWeight)
                                    {
                                        newVelocity2 = h2.physic2.getVelocity().calculateNewVelocity(h1.physic2.getVelocity(),h2.getPosition(),h1.getPosition());
                                    }
                                    if(h2.physic2.infiniteWeight)
                                    {
                                        newVelocity1 = h1.physic2.getVelocity().calculateNewVelocity(h2.physic2.getVelocity(),h1.getPosition(),h2.getPosition());
                                    }
                                    h1.physic2.setVelocity(newVelocity1);
                                    h2.physic2.setVelocity(newVelocity2);
                                    if(h1.parent.ID==2&&h2.parent.ID==3)
                                    {
                                        System.out.println(offset.x+"  ddwadaw  "+offset.y  + " dwadwd   "+h1.physic2.getVelocity().x );
                                    }


                                    if(c3>2)//calculate polished offset and position
                                    {
                                        Vector3 accurateOffset = new Vector3();
                                        float addition = 0;
                                        do {
                                            accurateOffset = accurateOffset.added(h1.physic2.getVelocity().zeroOrOned().multiplied(addition));
                                            addition++;
                                        }while(!h1.overlapsHitboxOffset(h2.getBoundsGlobal(), h2.getBoundsGlobalNegative(),accurateOffset));
                                   //     Vector3 setback = h1.physic2.getVelocity().zeroOrOned().multiplied(addition);
                                    //    setback = setback.multiplied(0);
                                   //     accurateOffset = accurateOffset.subbed(setback);
                                        h1.parent.addToPosition(accurateOffset);
                                    }
                                    collisionFound = true;
                                }
                                c3++;

                            }while(velocitySum > offset.mathAbs().sum()/2&&!collisionFound);
                        }
                    }
                }
            }
            h1.checked = true;
        }
        //endregion
        //region secondary
        //reset "checked" and check for onCollsionsExit
        for (int c1 = 0; c1 < hitbox2List.size(); c1++) {
            Hitbox2 h = hitbox2List.get(c1);
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
            Physic2 phy = GameCharacter.gameCharacterList.get(c1).physic2;
            if(!phy.fixed)
            {
                phy.handleVelocity();
            }
        }
    }
    public static void setGravityVelocity()
    {
        for (int c1 = 0; c1 < GameCharacter.gameCharacterList.size(); c1++) {
            Physic2 phy2 = GameCharacter.gameCharacterList.get(c1).getPhysic2();
            phy2.setVelocity(new Vector3(phy2.getVelocity().added(new Vector3(0,-1f,0))));
        }
    }
}
