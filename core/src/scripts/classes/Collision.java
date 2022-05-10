package scripts.classes;

import scripts.classes.ChildSUB.Hitbox3;

public class Collision {
    public Collision(Hitbox3 colliderPrimary, Hitbox3 colliderSecondary/*,Vector3 direction*/){
        this.colliderPrimary = colliderPrimary;
        this.colliderSecondary = colliderSecondary;
        refreshed = true;
    }





    public Hitbox3 colliderPrimary;
    public Hitbox3 colliderSecondary;





    public boolean refreshed;
    public boolean getRefreshedThisCycle(){return refreshed;}
    public void setRefreshedThisCycle(boolean b){refreshed = b;}
}
