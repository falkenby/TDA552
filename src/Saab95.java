import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Saab is a class that extends the superclass car.
 * It has a unique speedFactor method
 */
public class Saab95 extends Car {

    public Saab95() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
        point = new Point2D.Double(0, 0);
        direction = 'N';
        state = StateEngine.STOPPED;
        type = Workshop.Type.SAAB;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public Boolean turnTurboOn() {
        return turboOn = true;
    }

    public Boolean turnTurboOff() {
        return turboOn = false;
    }


}
