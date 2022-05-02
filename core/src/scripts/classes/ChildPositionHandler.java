package scripts.classes;

public class ChildPositionHandler
{
    public ChildPositionHandler(){}

    public Child child;




    public Vector2 handlePosition(Vector2 targetPosition){
       return targetPosition.copied();
    }
}
