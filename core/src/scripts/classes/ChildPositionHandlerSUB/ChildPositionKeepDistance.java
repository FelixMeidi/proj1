package scripts.classes.ChildPositionHandlerSUB;


import scripts.classes.ChildPositionHandler;
import scripts.classes.Vector3;

public class ChildPositionKeepDistance extends ChildPositionHandler
{
    public ChildPositionKeepDistance(Vector3 offset)
    {
        this.offset = offset;
    }

    private Vector3 offset;


    @Override
    public Vector3 handlePosition(Vector3 targetPosition)
    {
        return targetPosition.copied().added(offset);
    }
}
