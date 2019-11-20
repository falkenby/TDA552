import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends Car {

    public Scania() {
        nrDoors = 2;
        color = Color.blue;
        enginePower = 0.8;
        modelName = "Scania";
        stopEngine();
        point = new Point2D.Double(0, 0);
        direction = 'N';
        truckAngle = 0;

    }

    @Override
    public double speedFactor() {
        return enginePower;
    }

}
