package scripts.classes;

public class Child {
    public Child(ChildPositionHandler positionHandler)
    {
        this.parent = parent;
        this.positionHandler = positionHandler;
    }
    public Child()
    {
        this.positionHandler = new ChildPositionHandler();
    }






    public GameCharacter parent;
    public ChildPositionHandler positionHandler;



    public Vector3 getPosition(){
        return positionHandler.handlePosition(parent.getPosition()).copied();
    }
}
