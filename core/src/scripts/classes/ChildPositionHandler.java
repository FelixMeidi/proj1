package scripts.classes;

public class ChildPositionHandler
{
    public ChildPositionHandler(){}
    public Vector3 handlePosition(Vector3 targetPosition){
       return targetPosition.copied();
    }
}
