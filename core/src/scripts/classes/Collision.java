package scripts.classes;

import scripts.classes.ChildSUB.Hitbox2;

public class Collision {
    public Collision(Hitbox2 colliderPrimary,Hitbox2 colliderSecondary/*,Vector2 direction*/){
        this.colliderPrimary = colliderPrimary;
        this.colliderSecondary = colliderSecondary;
       /* this.direction = direction;*/
        refreshed = true;
    }





    public Hitbox2 colliderPrimary;
    public Hitbox2 colliderSecondary;





    public boolean refreshed;
    public boolean getRefreshedThisCycle(){return refreshed;}
    public void setRefreshedThisCycle(boolean b){refreshed = b;}



   /* public Vector2 direction;*/
}
