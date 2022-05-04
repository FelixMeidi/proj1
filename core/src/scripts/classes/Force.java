package scripts.classes;

public class Force {
    public Force(Vector3 directionVector3,float forceWeight,int id1,int id2)
    {
        this.directionVector3 = directionVector3;
        this.forceWeight = forceWeight;
        this.id1 = id1;
        this.id2 = id2;
    }
    protected Vector3 directionVector3;
    protected float forceWeight;
    public void setDirectionVector3(Vector3 v)
    {
        directionVector3 = v;
    }




    public Vector3 applyForce(Vector3 sourceVector3, boolean simulate)
    {
        return new Vector3(sourceVector3.added(directionVector3));
    }
    public boolean next()
    {
        return true;
    }
    public Vector3 simulateNext(int amount)
    {
        Vector3 source = directionVector3.copied();
        for(int c1 = 0;c1<amount;c1++)
        {
            source = source.added(source.copied());
        }
        return source;
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
