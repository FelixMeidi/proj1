package scripts.classes.Force_Inheritance;

import scripts.classes.Force;
import scripts.classes.Vector3;

public class ForceGravity extends Force {
    public ForceGravity(Vector3 directionVector3, int id1, int id2)
    {
        super(directionVector3,0,id1,id2);
    }


    @Override
    public Vector3 applyForce(Vector3 sourceVector3)
    {

        ///////////////
        /////////////////
        ////////////////////
        ////////////////////////
        return new Vector3(sourceVector3);
    }
    @Override
    public Vector3 simulateForce(Vector3 sourceVector3)
    {
        return new Vector3(sourceVector3.added(directionVector3));
    }
    @Override
    public boolean next()
    {
        return true;//true if delete
    }
}
