package scripts.classes.Force_Inheritance;

import scripts.classes.Force;
import scripts.classes.Vector3;

public class ForceGravity extends Force {
    public ForceGravity(Vector3 directionVector3, int id1, int id2)
    {
        super(directionVector3,id1,id2);
        this.strengthMultiplicator = 1;
    }
    public ForceGravity(Vector3 directionVector3, int id1, int id2,float strengthMultiplicator)
    {
        super(directionVector3,id1,id2);
        this.strengthMultiplicator = strengthMultiplicator;
    }

    private float strengthMultiplicator;

    @Override
    public Vector3 handleForce(Vector3 sourceVector3)
    {
        if(sourceVector3.y>=1)
        {
            sourceVector3.y = (float)Math.pow(Math.abs(sourceVector3.y),0.9*(1/strengthMultiplicator));
        }
        else if(sourceVector3.y<=-1)
        {
            sourceVector3.y = -((float)Math.pow(Math.abs(sourceVector3.y),1.2*Math.abs(strengthMultiplicator)));
        }
        else
        {
            sourceVector3.y = -1.1f;
        }
        return new Vector3(sourceVector3);
    }
}
