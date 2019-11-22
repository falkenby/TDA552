
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void testVolvoSpeed() {
        Volvo240 myCar = new Volvo240();
        myCar.incrementSpeed(1);
        myCar.getCurrentSpeed();
        assertEquals(1.25, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testSaabSpeed() {
        Saab95 myCar = new Saab95();
        myCar.incrementSpeed(1);
        myCar.getCurrentSpeed();
        assertEquals(1.25, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testVolvoDecSpeed() {
        Volvo240 myCar = new Volvo240();
        myCar.incrementSpeed(1);
        myCar.decrementSpeed(1);
        myCar.getCurrentSpeed();
        assertEquals(0.0, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testSaabDecSpeed() {
        Saab95 myCar = new Saab95();
        myCar.incrementSpeed(1);
        myCar.decrementSpeed(1);
        myCar.getCurrentSpeed();
        assertEquals(0.0, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testVolvoGas() {
        Volvo240 myCar = new Volvo240();
        myCar.gas(1);
        myCar.getCurrentSpeed();
        assertEquals(1.25, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testSaabGas() {
        Saab95 myCar = new Saab95();
        myCar.gas(1);
        myCar.getCurrentSpeed();
        assertEquals(1.25, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testSaabBrake() {
        Saab95 myCar = new Saab95();
        myCar.gas(1);
        myCar.brake(1);
        myCar.getCurrentSpeed();
        assertEquals(0.0, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testVolvoBrake() {
        Volvo240 myCar = new Volvo240();
        myCar.gas(1);
        myCar.brake(1);
        myCar.getCurrentSpeed();
        assertEquals(0.0, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test(expected = RuntimeException.class)
    public void testVolvoBrakeError() {

        Volvo240 myCar = new Volvo240();
        myCar.gas(1);
        myCar.brake(2);
    }

    @Test(expected = RuntimeException.class)
    public void testSaabBrakeError() {

        Saab95 myCar = new Saab95();
        myCar.gas(1);
        myCar.brake(2);
    }

    @Test(expected = RuntimeException.class)
    public void testVolvoGasError() {

        Volvo240 myCar = new Volvo240();
        myCar.gas(1);
        myCar.brake(2);
    }

    @Test(expected = RuntimeException.class)
    public void testSaabGasError() {

        Saab95 myCar = new Saab95();
        myCar.gas(1);
        myCar.brake(2);
    }

    @Test
    public void testVolvoMove() {

        Volvo240 myCar = new Volvo240();
        myCar.startEngine();
        myCar.move();
        assertEquals(myCar.getDirection(), 'N');
        assertEquals(myCar.point.getX(), 0.0, 0.000001);
        assertEquals(myCar.point.getY(), 0.1, 0.000001);
    }

    @Test
    public void testVolvoTurnLeft() {

        Volvo240 myCar = new Volvo240();
        myCar.startEngine();
        myCar.turnLeft();
        assertEquals(myCar.getDirection(), 'W');
    }

    @Test
    public void testVolvoTurnRight() {

        Volvo240 myCar = new Volvo240();
        myCar.startEngine();
        myCar.turnRight();
        assertEquals(myCar.getDirection(), 'E');
    }

    @Test
    public void testSaabMove() {

        Saab95 myCar = new Saab95();
        myCar.startEngine();
        myCar.move();
        assertEquals(myCar.getDirection(), 'N');
        assertEquals(myCar.point.getX(), 0.0, 0.000001);
        assertEquals(myCar.point.getY(), 0.1, 0.000001);
    }

    @Test
    public void testSaabTurnLeft() {

        Saab95 myCar = new Saab95();
        myCar.startEngine();
        myCar.turnLeft();
        assertEquals(myCar.getDirection(), 'W');
    }

    @Test
    public void testSaabTurnRight() {

        Saab95 myCar = new Saab95();
        myCar.startEngine();
        myCar.turnRight();
        assertEquals(myCar.getDirection(), 'E');
    }

}
