package scripts.classes;

public class Child {
    public Child(GameCharacter parent, ChildPositionHandler positionHandler)
    {
        this.parent = parent;
        this.positionHandler = positionHandler;
    }






    public GameCharacter parent;
    public ChildPositionHandler positionHandler;



    public Vector3 getPosition(){
        return positionHandler.handlePosition(parent.getPosition()).copied();
    }
}
