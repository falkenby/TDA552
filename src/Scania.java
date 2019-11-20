import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends Car{

    public Scania() {
        nrDoors = 2;
        color = Color.blue;
        enginePower = 200;
        modelName = "Scania";
        stopEngine();
        trimFactor = 1.25;
        point = new Point2D.Double(0, 0);
        direction = 'N';
        isMoving = false;
        truckAngle = 0;

    }

    @Override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

}
