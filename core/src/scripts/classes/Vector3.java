package scripts.classes;

public class Vector3 {
    public float x,y,z;
    public static Vector3 zero = new Vector3(0,0,0);
    public Vector3(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3()
    {
        x = 0;
        y = 0;
        z = 0;
    }
    public Vector3(Vector3 v2)
    {
        x = v2.x;
        y = v2.y;
        z = v2.z;
    }











    public void reset()
    {
        x = 0;
        y = 0;
        z = 0;
    }
    public Vector3 copied()
    {
        return new Vector3(this);
    }
    public Vector3 zeroOrOned()
    {
        float x2;
        float y2;
        float z2;
        if(x>0)
        {
            x2 = 1;
        }
        else if(x==0)
        {
            x2 = 0;
        }
        else
        {
            x2 = -1;
        }

        if(y>0)
        {
            y2 = 1;
        }
        else if(y==0)
        {
            y2 = 0;
        }
        else
        {
            y2 = -1;
        }

        if(z>0)
        {
            z2 = 1;
        }
        else if(z==0)
        {
            z2 = 0;
        }
        else
        {
            z2 = -1;
        }
        return new Vector3(x2,y2,z2);
    }






    public float sum()
    {
        return x+y+z;
    }
    public Vector3 valued()
    {
        return new Vector3(Math.abs(x),Math.abs(y),Math.abs(z));
    }











    public Vector3 added(Vector3 addVector)
    {
        return  new Vector3(this.x+addVector.x,this.y+addVector.y,this.z+ addVector.z);
    }


    public Vector3 subbed(Vector3 subVector)
    {
        return  new Vector3(this.x-subVector.x,this.y-subVector.y,this.z-subVector.z);
    }

    public Vector3 multiplied(float value)
    {
        return new Vector3(x*value,y*value,z*value);
    }

    public Vector3 multiplied(Vector3 v2)
    {
        return new Vector3(x*v2.x,y*v2.y,z*v2.z);
    }
    public Vector3 divided(Vector3 v2)
    {
        return new Vector3(x/v2.x,y/v2.y,z/v2.z);
    }
    public Vector3 divided(float d)
    {
        return new Vector3(x/d,y/d,z/d);
    }

    //// update from here

    public Vector3 calculateNewVelocity(Vector3 v2, Vector3 pos1, Vector3 pos2, float weight1, float weight2)
    {
        Vector3 diff = pos2.subbed(pos1);
        diff.x = Math.abs(diff.x);
        diff.y = Math.abs(diff.y);
        diff.z = Math.abs(diff.z);
        boolean calculateX = false;
        boolean calculateY = false;
        boolean calculateZ = false;
        if(diff.x>diff.y&&diff.x>diff.z)
        {
            calculateX = true;
        }
        else if(diff.y>=diff.x&&diff.y>=diff.z)
        {
            calculateY = true;
        }
        else
        {
            calculateZ = true;
        }
        Vector3 v = this.copied();
        if(calculateX||calculateY) {
            if (calculateY) {
                v.y = (v.y * weight1 + v2.y * weight2) / (weight1 + weight2);
            }
            if (calculateX) {
                v.x = (v.x * weight1 + v2.x * weight2) / (weight1 + weight2);
            }
            if (calculateZ) {
                v.z = (v.z * weight1 + v2.z * weight2) / (weight1 + weight2);
            }
            return v;
        }
        return v.multiplied(weight1).added(v2.multiplied(weight2)).divided(weight1+weight2);
    }

    public Vector3 calculateNewVelocity(Vector3 v2, Vector3 pos1, Vector3 pos2)
    {
        Vector3 diff = pos2.subbed(pos1);
        diff.x = Math.abs(diff.x);
        diff.y = Math.abs(diff.y);
        diff.z = Math.abs(diff.z);
        Vector3 v = this.copied();
        if(diff.x>diff.y&&diff.x>diff.z)
        {
            v.x = 0;
        }
        else if(diff.y>=diff.x&&diff.y>=diff.z)
        {
            v.y = 0;
        }
        else
        {
            v.z = 0;
        }
        return v;
    }
}
