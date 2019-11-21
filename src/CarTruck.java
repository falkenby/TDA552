import java.awt.*;
import java.awt.geom.Point2D;

public class CarTruck extends Truck{

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

    /**
     * A method for raising the truckbed on the CarTruck
     *
     * @param angle
     */

    @Override
    public void raiseTruckBed(double angle) {
        if (this.currentSpeed > 0 ) {
            throw new RuntimeException("Cannot raise truckbed when truck is moving!");
        }

        ramp = true;

    }

    /**
     * A method for lowering the truckbed on Scania
     *
     * @param angle
     */

    @Override
    public void lowerTruckBed(double angle) {
        if (this.currentSpeed > 0) {
            throw new RuntimeException("Cannot lower truckbed when truck is moving!");
        }

        ramp = false;
    }



}
