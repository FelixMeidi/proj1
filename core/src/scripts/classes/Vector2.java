package scripts.classes;

public class Vector2 {
    public float x,y;
    public static Vector2 zero = new Vector2(0,0);
    public Vector2(float x,float y)
    {
        this.x = x;
        this.y = y;
    }
    public Vector2()
    {
        x = 0;
        y = 0;
    }
    public Vector2(Vector2 v2)
    {
        x = v2.x;
        y = v2.y;
    }






    public Vector2 normalized()
    {
        return new Vector2(x/(y+x),y/(y+x));
    }
    public float pytLength()
    {
        return (float)Math.sqrt(x*x+y*y);
    }

    public void reset()
    {
        x = 0;
        y = 0;
    }
    public Vector2 copied()
    {
        return new Vector2(this);
    }
    public Vector2 zeroOrOned()
    {
        float x2;
        float y2;
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
        return new Vector2(x2,y2);
    }






    public void invert()
    {
        x = -x;
        y = -y;
    }
    public float sum()
    {
        return x+y;
    }
    public Vector2 valued()
    {
        return new Vector2(Math.abs(x),Math.abs(y));
    }











    public Vector2 added(Vector2 addVector)
    {
        return  new Vector2(this.x+addVector.x,this.y+addVector.y);
    }


    public Vector2 subbed(Vector2 subVector)
    {
        return  new Vector2(this.x-subVector.x,this.y-subVector.y);
    }

    public Vector2 multiplied(float value)
    {
        return new Vector2(x*value,y*value);
    }

    public Vector2 multiplied(Vector2 v2)
    {
        return new Vector2(x*v2.x,y*v2.y);
    }
    public Vector2 divided(Vector2 v2)
    {
        return new Vector2(x/v2.x,y/v2.y);
    }
    public Vector2 divided(float d)
    {
        return new Vector2(x/d,y/d);
    }


    public Vector2 directionApplied(Vector2 pos1,Vector2 pos2)
    {
        Vector2 diff = pos2.subbed(pos1);
        diff.x = Math.abs(diff.x);
        diff.y = Math.abs(diff.y);
        Vector2 result = new Vector2();
        if(diff.x>y)
        {
            result.x = x;
        }
        else if(diff.x<y)
        {
            result.y = y;
        }
        else
        {
            result = this.copied();
        }
        System.out.println(result.x + "------------------");
        return result;
    }

    public Vector2 calculateNewVelocity(Vector2 v2,Vector2 pos1,Vector2 pos2,float weight1, float weight2)
    {
        Vector2 diff = pos2.subbed(pos1);
        diff.x = Math.abs(diff.x);
        diff.y = Math.abs(diff.y);
        boolean calculateX = false;
        boolean calculateY = false;
        if(diff.x>y)
        {
            calculateX = true;
        }
        else if(diff.x<y)
        {
            calculateY = true;
        }
        Vector2 v = this.copied();
        if(calculateX||calculateY) {
            if (calculateY) {
                v.y = (v.y * weight1 + v2.y * weight2) / (weight1 + weight2);
            }
            if (calculateX) {
                v.x = (v.x * weight1 + v2.x * weight2) / (weight1 + weight2);
            }
            return v;
        }
        return v.multiplied(weight1).added(v2.multiplied(weight2)).divided(weight1+weight2);
    }

    public Vector2 calculateNewVelocity(Vector2 v2,Vector2 pos1,Vector2 pos2)
    {
        Vector2 diff = pos2.subbed(pos1);
        diff.x = Math.abs(diff.x);
        diff.y = Math.abs(diff.y);
        Vector2 v = this.copied();
        if(diff.x>diff.y)
        {
            v.x = 0;
        }
        else if(diff.x<diff.y)
        {
            v.y = 0;
        }
        return v;
    }


    public boolean Equals(Vector2 vec2)
    {
        if(x==vec2.x&&y==vec2.y)
        {
            return  true;
        }
        return false;
    }



    public static Vector2 up = new Vector2(0,1);
    public static Vector2 down = new Vector2(0,-1);
    public static Vector2 left = new Vector2(-1,0);
    public static Vector2 right = new Vector2(1,0);



    public static Vector2 getAvarageFactored(Vector2 v1, Vector2 v2, float factorOne, float factorTwo)
    {
        Vector2 v1f = v1.multiplied(factorOne);
        Vector2 v2f = v2.multiplied(factorTwo);
        return getAvaraged(v1f,v2f).divided(factorOne+factorTwo);

    }
    public Vector2 getRelationFactored(Vector2 v2, float factorOne, float factorTwo)
    {
        Vector2 v = this.copied();
        if(v2.x==0||v2.y ==0) {
            if (v2.y != 0) {
                v.y = (v.y * factorOne + v2.y * factorTwo) / (factorOne + factorTwo);
            }
            if (v2.x != 0) {
                v.x = (v.x * factorOne + v2.x * factorTwo) / (factorOne + factorTwo);
            }
            return v;
        }
        return v.multiplied(factorOne).added(v2.multiplied(factorTwo)).divided(factorOne+factorTwo);
    }

    public static Vector2 getAvaraged(Vector2 v1, Vector2 v2)
    {
        return new Vector2((v1.x+v2.x)/2,(v1.y+v2.y)/2);
    }
}
