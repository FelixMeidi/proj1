package scripts.classes;

public class Force {
    public Force(Vector3 directionVector3,int id1,int id2)
    {
        this.directionVector3 = directionVector3;
        this.id1 = id1;
        this.id2 = id2;
    }
    protected Vector3 directionVector3;
    public void setDirectionVector3(Vector3 v)
    {
        directionVector3 = v;
    }

    public Vector3 handleForce(Vector3 sourceVector3)
    {
        if(directionVector3.x!=0)
        {
            System.out.println("");
        }
        return new Vector3(sourceVector3.added(directionVector3));
    }







    ////////////// IDENTIFICATION /////////////////////
    protected int id1;
    protected int id2;
    public boolean checkId(int id1,int id2)
    {
        if(this.id1==id1&&this.id2==id2)
        {
            return true;
        }
        return false;
    }
}
