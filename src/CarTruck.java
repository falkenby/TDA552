import java.awt.*;
import java.awt.geom.Point2D;

public class CarTruck extends Car{

    public CarTruck() {
        nrDoors = 2;
        color = Color.green;
        enginePower = 0.9;
        modelName = "CarTruck";
        stopEngine();
        point = new Point2D.Double(0, 0);
        direction = 'N';
        ramp = true;

    }

    @Override
    public double speedFactor() {
        return enginePower;
    }
}
