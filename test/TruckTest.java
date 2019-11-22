import org.junit.Test;

import static org.junit.Assert.*;

public class TruckTest {
    @Test
    public void testScaniaSpeed() {
        Scania myCar = new Scania();
        myCar.incrementSpeed(1);
        myCar.getCurrentSpeed();
        assertEquals(0.8, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testCarTruckSpeed() {
        CarTruck myCar = new CarTruck(10);
        myCar.incrementSpeed(1);
        myCar.getCurrentSpeed();
        assertEquals(0.9, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testScaniaDecSpeed() {
        Scania myCar = new Scania();
        myCar.incrementSpeed(1);
        myCar.decrementSpeed(1);
        myCar.getCurrentSpeed();
        assertEquals(0.0, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testCarTruckDecSpeed() {
        CarTruck myCar = new CarTruck(10);
        myCar.incrementSpeed(1);
        myCar.decrementSpeed(1);
        myCar.getCurrentSpeed();
        assertEquals(0.0, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testScaniaGas() {
        Scania myCar = new Scania();
        myCar.gas(1);
        myCar.getCurrentSpeed();
        assertEquals(0.8, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testCarTruckGas() {
        CarTruck myCar = new CarTruck(10);
        myCar.gas(1);
        myCar.getCurrentSpeed();
        assertEquals(0.9, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testCarTruckBrake() {
        CarTruck myCar = new CarTruck(10);
        myCar.gas(1);
        myCar.brake(1);
        myCar.getCurrentSpeed();
        assertEquals(0.0, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void testScaniaBrake() {
        Scania myCar = new Scania();
        myCar.gas(1);
        myCar.brake(1);
        myCar.getCurrentSpeed();
        assertEquals(0.0, myCar.getCurrentSpeed(), 0.000001);
    }

    @Test(expected = RuntimeException.class)
    public void testScaniaBrakeError() {

        Scania myCar = new Scania();
        myCar.gas(1);
        myCar.brake(2);
    }

    @Test(expected = RuntimeException.class)
    public void testCarTruckBrakeError() {

        CarTruck myCar = new CarTruck(10);
        myCar.gas(1);
        myCar.brake(2);
    }

    @Test(expected = RuntimeException.class)
    public void testScaniaGasError() {

        Scania myCar = new Scania();
        myCar.gas(1);
        myCar.brake(2);
    }

    @Test(expected = RuntimeException.class)
    public void testCarTruckGasError() {

        CarTruck myCar = new CarTruck(10);
        myCar.gas(1);
        myCar.brake(2);
    }

    @Test
    public void testScaniaMove() {

        Scania myCar = new Scania();
        myCar.startEngine();
        myCar.move();
        assertEquals(myCar.getDirection(), 'N');
        assertEquals(myCar.point.getX(), 0, 00001);
        assertEquals(myCar.point.getX(), 1, 00001);
    }

    @Test
    public void testScaniaTurnLeft() {

        Scania myCar = new Scania();
        myCar.startEngine();
        myCar.turnLeft();
        assertEquals(myCar.getDirection(), 'W');
    }

    @Test
    public void testScaniaTurnRight() {

        Scania myCar = new Scania();
        myCar.startEngine();
        myCar.turnRight();
        assertEquals(myCar.getDirection(), 'E');
    }

    @Test
    public void testCarTruckMove() {

        CarTruck myCar = new CarTruck(10);
        myCar.startEngine();
        myCar.move();
        assertEquals(myCar.getDirection(), 'N');
        assertEquals(myCar.point.getX(), 0, 00001);
        assertEquals(myCar.point.getX(), 1, 00001);
    }

    @Test(expected = RuntimeException.class)
    public void testCarTruckMoveError() {

        CarTruck myCar = new CarTruck(10);
        myCar.startEngine();
        myCar.raiseTruckBed(40);
        myCar.move();
    }

    @Test
    public void testCarTruckTurnLeft() {

        CarTruck myCar = new CarTruck(10);
        myCar.startEngine();
        myCar.turnLeft();
        assertEquals(myCar.getDirection(), 'W');
    }

    @Test
    public void testCarTruckTurnRight() {

        CarTruck myCar = new CarTruck(10);
        myCar.startEngine();
        myCar.turnRight();
        assertEquals(myCar.getDirection(), 'E');
    }
}
