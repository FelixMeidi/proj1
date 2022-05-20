package scripts.classes;

import java.util.ArrayList;
import java.util.List;

public class GameCharacter
{
    protected GameCharacter(int ID)
    {
        positon = new Vector3();
        childList = new ArrayList<Child>();
        this.ID = ID;
    }
    protected GameCharacter(int ID, ArrayList<Child> list)
    {
        positon = new Vector3();
        childList = list;
        this.ID = ID;
    }

    public int ID;




    public static List<GameCharacter> gameCharacterList = new ArrayList<GameCharacter>();








    protected Vector3 positon;
    public Vector3 getPosition(){return positon.copied();}
    public void setPosition(Vector3 targetposition)
    {
        positon = targetposition;
    }
    public void addToPosition(Vector3 addedPosition)
    {
        positon = positon.added(addedPosition);
    }





    public Physic3 getPhysic3()
    {
        return (Physic3)getfromChildList("Physic3");
    }






    private List<Child> childList;
    public void addtoChildList(Child c)
    {
        c.parent = this;
        childList.add(c);
    }
    public Child getfromChildList(int index){return childList.get(index);}

    public Child getfromChildList(String className)
    {
        for(int c1 = 0;c1<childList.size();c1++)
        {
            if (childList.get(c1).toString() == className)
            {
                return childList.get(c1);
            }
        }
        return  null;
    }
}
