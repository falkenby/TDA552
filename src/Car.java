import java.awt.*;

/**
 * An abstract superclass Car that is extended by the carmodels Volvo240 and Saab95.
 * It also implements Movable, which is used to turn the car.
 * It is an abstract class so that
 */

public abstract class Car implements Movable {

    /**
     * protected is used as to not have it be modified from the outside.
     */
    protected double trimFactor; // How much the engine is trimmed
    protected boolean turboOn; // Turbo-switch
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double x; // x position
    protected double y; // y postition

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    public void brake(double amount) {
        if (amount < 0.0 || amount > 1.0) {
            throw new RuntimeException("The brake can't go above 1 nor below 0");
        }
        decrementSpeed(amount);

    }

    public void gas(double amount) {
        if (amount < 0.0 || amount > 1.0) {
            throw new RuntimeException("The gas can't go above 1 nor below 0");
        }
        incrementSpeed(amount);

    }



    /*Movable methods call*/

    @Override
    public void move() {
        y += currentSpeed;
    }

    @Override
    public void turnRight() {
        x += currentSpeed;
    }

    @Override
    public void turnLeft() {
        x = x + (-1 * currentSpeed);
    }


}