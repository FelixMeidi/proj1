package scripts.classes;

import scripts.classes.ChildSUB.Hitbox3;

import java.util.ArrayList;
import java.util.List;

public /*static*/ final class PhysicHandler
{
    private PhysicHandler() {}





    public static List<Hitbox3> hitbox3List = new ArrayList<>();






    public static void updateHitboxes()
    {/*
        for (int c1 = 0; c1 < hitbox3List.size(); c1++) {
            Hitbox3 h1 = hitbox3List.get(c1);
            if (h1.activated&&!h1.checked) {//check next frame, not this!-------
                for (int c2 = 0; c2 < hitbox3List.size(); c2++) {
                    Hitbox3 h2 = hitbox3List.get(c2);
                    if (h2.activated&&!h2.checked) {
                        if (c1 != c2) {
                            //calculate offset
                   //         int c3 = 1;
                 //           Vector3 offset;
                   //         float velocitySum = h1.physic3.getVelocity().sum()/100;
                  //          boolean collisionFound = false;
                   //         do{
           //                     offset = h1.physic3.getVelocity().zeroOrOned().multiplied(c3);
                       //         if (h1.overlapsHitboxOffset(h2.getBoundsGlobal(), h2.getBoundsGlobalNegative(),offset)) {
                             //       h1.onCollision(new Collision(h1, h2));
                             //       h2.onCollision(new Collision(h2, h1));


                                    Vector3 newVelocity1 = h1.physic3.getVelocity().calculateNewVelocity(h2.physic3.getVelocity(),h1.getPosition(),h2.getPosition(),h1.physic3.getWeight(),h2.physic3.getWeight());
//
                                    Vector3 newVelocity2 = h2.physic3.getVelocity().calculateNewVelocity(h1.physic3.getVelocity(),h2.getPosition(),h1.getPosition(),h2.physic3.getWeight(),h1.physic3.getWeight());

                                    if(h1.physic3.getInfiniteWeight())
                                    {
                                        newVelocity2 = h2.physic3.getVelocity().calculateNewVelocity(h1.physic3.getVelocity(),h2.getPosition(),h1.getPosition());
                                    }
                                    if(h2.physic3.getInfiniteWeight())
                                    {
                                        newVelocity1 = h1.physic3.getVelocity().calculateNewVelocity(h2.physic3.getVelocity(),h1.getPosition(),h2.getPosition());
                                    }
                                    h1.physic3.addToForceList(new Force(newVelocity1,h1.parent.getId(),h2.parent.getId()));
                                    h2.physic3.addToForceList(new Force(newVelocity2,h2.parent.getId(),h1.parent.getId()));




                                    if(c3>2)//calculate polished offset and position
                                    {
                                        Vector3 accurateOffset = new Vector3();
                                        float addition = 0;
                                        do {
                                            accurateOffset = accurateOffset.added(h1.physic3.getVelocity().zeroOrOned().multiplied(addition));
                                            addition++;
                                        }while(!h1.overlapsHitboxOffset(h2.getBoundsGlobal(), h2.getBoundsGlobalNegative(),accurateOffset));
                                   //     Vector3 setback = h1.physic3.getVelocity().zeroOrOned().multiplied(addition);
                                    //    setback = setback.multiplied(0);
                                   //     accurateOffset = accurateOffset.subbed(setback);
                                        h1.parent.addToPosition(accurateOffset);
                                    }
                                    collisionFound = true;
                                }
                      //          c3++;

                      //      }while(velocitySum > offset.mathAbs().sum()/2&&!collisionFound);
                        }
                    }
                }
            }
        //    h1.checked = true;
        }






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
        }*/
    }
    public static void applyVelocities()
    {
        for (int c1 = 0; c1 < GameCharacter.gameCharacterList.size(); c1++) {
            Physic3 phy = GameCharacter.gameCharacterList.get(c1).physic3;
            phy.handleVelocity();
        }
    }
    public static void setGravityVelocity() {//////////////////////////
        for (int c1 = 0; c1 < GameCharacter.gameCharacterList.size(); c1++) {
            Physic3 phy2 = GameCharacter.gameCharacterList.get(c1).getPhysic3();
            if (!phy2.checkForForceInForceListID(-2, phy2.getGameCharacter().getId())) {
         //       phy2.addToForceList(new Force(new Vector3(0,-1,0), -2, phy2.getGameCharacter().getId()));
            }
        }
    }
}
