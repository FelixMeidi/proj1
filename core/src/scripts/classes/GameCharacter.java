package scripts.classes;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public class GameCharacter
{
    protected GameCharacter(int ID,Texture img,float weight, boolean fixed)
    {
        positon = new Vector2();
        physic2 = new Physic2(this,fixed,false,weight);
        childList = new ArrayList<Child>();
        tx = img;
        this.ID = ID;
    }
    protected GameCharacter(int ID,Texture img,boolean fixed)
    {
        positon = new Vector2();
        physic2 = new Physic2(this,fixed,true,314);
        childList = new ArrayList<Child>();
        tx = img;
        this.ID = ID;
    }

    public int ID;




    public static List<GameCharacter> gameCharacterList = new ArrayList<GameCharacter>();








    protected Vector2 positon;
    public Vector2 getPositon(){return positon.copied();}
    public void setPosition(Vector2 targetposition){
        positon = targetposition;
    }
    public void addToPosition(Vector2 addedPosition)
    {
        positon = positon.added(addedPosition);
    }





    protected Physic2 physic2;
    public Physic2 getPhysic2(){return physic2;}






    private List<Child> childList;
    public void addtoChildList(Child c)
    {
        childList.add(c);
    }
    public Child getfromChildList(int index){return childList.get(index);}


    public Texture tx;
}
