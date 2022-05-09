package scripts.classes.Force_Inheritance;

import scripts.classes.Force;
import scripts.classes.Vector3;

public class ForceNoRemove extends Force {
    public ForceNoRemove(Vector3 directionVector3, float forceWeight, int id1, int id2)
    {
        super(directionVector3,forceWeight,id1,id2);
    }
    @Override
    public boolean next(){return false;}
}
