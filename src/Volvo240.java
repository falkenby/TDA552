import java.awt.*;


public class Volvo240 extends Car {

    public Volvo240() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
        trimFactor = 1.25;
        y = 0;
        x = 0;
    }

    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    @Override
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }


}
