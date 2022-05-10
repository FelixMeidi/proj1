package scripts.classes.ChildSUB;

import com.badlogic.gdx.graphics.Texture;
import scripts.classes.*;

import java.util.ArrayList;

public class TextureChild extends Child
{

    ////////////////////////////
    public static ArrayList<TextureChild> textureList = new ArrayList<>();
    //////////////////////////


    public TextureChild(Texture tx, GameCharacter parent,ChildPositionHandler handler,Vector3 rootoffset)
    {
        super(parent,handler);
        this.tx = tx;
        textureList.add(this);
        this.rootoffset = rootoffset;
    }
    public TextureChild(Texture tx, GameCharacter parent, Vector3 rootoffset)
    {
        super(parent,new ChildPositionHandler());
        this.tx = tx;
        textureList.add(this);
        this.rootoffset = rootoffset;
    }
    public TextureChild(Texture tx, GameCharacter parent)
    {
        super(parent,new ChildPositionHandler());
        this.tx = tx;
        textureList.add(this);
        this.rootoffset = Vector3.zero;
    }
    public Texture tx;
    public boolean rendered;
    public Vector3 rootoffset;

    @Override
    public Vector3 getPosition(){
        return positionHandler.handlePosition(parent.getPosition()).copied().added(rootoffset);
    }
}
