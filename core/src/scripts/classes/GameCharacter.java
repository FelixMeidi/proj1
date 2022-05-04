package scripts.classes;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

public class GameCharacter
{
    protected GameCharacter(int ID,Texture img,float weight, boolean fixed)
    {
        positon = new Vector3();
        physic3 = new Physic3(this,weight,fixed,false,true);
        childList = new ArrayList<Child>();
        tx = img;
        this.ID = ID;
    }
    protected GameCharacter(int ID,Texture img,boolean fixed)
    {
        positon = new Vector3();
        physic3 = new Physic3(this,0,fixed,true,true);
        childList = new ArrayList<Child>();
        tx = img;
        this.ID = ID;
    }

    private int ID;
    public int getId(){return ID;}




    public static List<GameCharacter> gameCharacterList = new ArrayList<GameCharacter>();








    protected Vector3 positon;
    public Vector3 getPositon(){return positon.copied();}
    public void setPosition(Vector3 targetposition){
        positon = targetposition;
    }






    protected Physic3 physic3;
    public Physic3 getPhysic3(){return physic3;}






    private List<Child> childList;
    public void addtoChildList(Child c)
    {
        childList.add(c);
    }
    public Child getfromChildList(int index){return childList.get(index);}









    public Texture tx;
}
