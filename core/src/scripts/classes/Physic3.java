package scripts.classes;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public class Physic3 {
    //region constructors
    public Physic3(GameCharacter gameCharacter,float weight, boolean fixed, boolean infiniteWeight,boolean affectedByGravity ){
        this.gameCharacter = gameCharacter;
        this.fixed = fixed;
        this.infiniteWeight = infiniteWeight;
        this.weight = weight;
        this.affectedByGravity = affectedByGravity;
        this.lastVelocity = new Vector3();
    }



    private GameCharacter gameCharacter;
    public GameCharacter getGameCharacter(){return gameCharacter;}



    private boolean fixed;
    public boolean getFixed(){return fixed;}

    private boolean infiniteWeight;
    public boolean getInfiniteWeight(){return infiniteWeight;}

    private boolean affectedByGravity;
    public boolean getAffectedByGravity(){return affectedByGravity;}


    private float weight;
    public float getWeight(){return weight;}






    public Vector3 lastVelocity;






    private ArrayList<Force> forceList = new ArrayList<>();
    public boolean addToForceList(Force f)
    {
        if(!searchForForceInForceList(f))
        {
            forceList.add(f);
            return true;
        }
        return false;
    }


    public boolean searchForForceInForceList(Force f)
    {
        for(int c1 = 0;c1<forceList.size();c1++)
        {
            if(forceList.get(c1)==f)
            {
                return true;
            }
        }
        return false;
    }


    public boolean checkForForceInForceListID(int id1,int id2)
    {
        for(int c1 = 0;c1<forceList.size();c1++)
        {
            if(forceList.get(c1).checkId(id1,id2))
            {
                return true;
            }
        }
        return false;
    }
















    public void handleVelocity()
    {
        //applying velocity
        Vector3 v = new Vector3();
        for(int c1 = 0;c1<forceList.size();c1++)
        {
            v = forceList.get(c1).applyForce(v.copied());
        }
        gameCharacter.setPosition(gameCharacter.getPositon().added(v.multiplied(Gdx.graphics.getDeltaTime()).multiplied(100)));





        //clearing list
        for(int c1 = 0;c1<forceList.size();c1++)
        {
            if(forceList.get(c1).next())
            {
                forceList.remove(c1);
                c1=0;
            }
        }
    }




    public Vector3 simulateVelocity()
    {
        //simulating
        Vector3 v = new Vector3();
        for(int c1 = 0;c1<forceList.size();c1++)
        {
            v = forceList.get(c1).simulateForce(v.copied());
        }
        return v.copied();
    }
}