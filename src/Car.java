import java.awt.*;
import java.awt.geom.Point2D;

import static java.lang.Math.*;

/**
 * An abstract superclass Car that is extended by the carmodels Volvo240 and Saab95.
 * It also implements Movable, which is used to turn the car.
 * It is an abstract class so that
 */

public abstract class Car implements Movable {

    /* Used protected due to it being used in Volvo240 and Saab95*/
    protected double trimFactor; // How much the engine is trimmed
    protected boolean turboOn; // Turbo-switch
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected Point2D.Double point; // Coordinate system in a 2D coordinate system
    protected char direction; // direction of the turning
    protected boolean ramp; // boolean if the truck is moving or not
    protected double truckAngle; // truck angle


    /* Getters and Setters*/

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

    public Point2D.Double getPoint() {
        return this.point;
    }

    public char getDirection() {
        return this.direction;
    }

    public double getAngle() {
        return truckAngle;
    }

    public boolean isRampDown() {
        return ramp;
    }

    /**
     * A method for raising the truckbed on Scania
     *
     * @param angle
     */
    public void raiseTruckBed(double angle) {
        if (this.currentSpeed > 0 || (this.truckAngle + angle) > 70 || (this.truckAngle + angle) < 0) {
            throw new RuntimeException("Cannot raise truckbed when truck is moving!");
        }

        this.truckAngle += angle;

    }

    /**
     * A method for lowering the truckbed on Scania
     *
     * @param angle
     */

    public void lowerTruckBed(double angle) {
        if (this.currentSpeed > 0 || (this.truckAngle - angle) > 70 || (this.truckAngle - angle) < 0) {
            throw new RuntimeException("Cannot raise truckbed when truck is moving!");
        }

        this.truckAngle -= angle;
    }


    /**
     * Abstract method for speedFactor, because the speedFactor is unique for each car
     */
    public abstract double speedFactor();

    /**
     * Incrementing the speed, is called by gas()
     */

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Decrementing the speed, is called by brake()
     */

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /**
     * Slowing down the car, amount must be between 0 and 1
     */

    public void brake(double amount) {
        if (amount < 0.0 || amount > 1.0) {
            throw new RuntimeException("The brake can't go above 1 nor below 0");
        }
        decrementSpeed(amount);

    }

    /**
     * Speeding up the car, amount must be between 0 and 1
     * Also catches if the truck has an truckangle of more than 0
     */

    public void gas(double amount) {
        if (amount < 0.0 || amount > 1.0) {
            throw new RuntimeException("The gas can't go above 1 nor below 0");
        }
        if (this.truckAngle > 0 || ramp == false) {
            throw new RuntimeException("Cannot move the truck when the truckbed is not in the down position!");
        }
        incrementSpeed(amount);

    }


    /**
     * Movable methods call, uses the Point2D system with a double x and a double y
     * Changes speed depending on direction
     */


    @Override
    public void move() {

        switch (this.direction) {
            case 'N':
                this.point.setLocation(this.point.getX(), (this.point.getY() + this.currentSpeed));
                break;
            case 'W':
                this.point.setLocation((this.point.getX() + this.currentSpeed), this.point.getY());
                break;
            case 'E':
                this.point.setLocation((this.point.getX() - this.currentSpeed), this.point.getY());
                break;
            case 'S':
                point.setLocation(point.getX(), (point.getY() - currentSpeed));
                break;

        }

    }

    /**
     * Rotates the car 90 degrees to the right
     */
    @Override
    public void turnRight() {

        switch (this.direction) {
            case 'N':
                this.direction = 'E';
                break;
            case 'W':
                this.direction = 'N';
                break;
            case 'E':
                this.direction = 'S';
                break;
            case 'S':
                this.direction = 'W';
                break;

        }


    }

    /**
     * Rotates the car 90 degrees to the left
     */
    @Override
    public void turnLeft() {

        switch (this.direction) {
            case 'N':
                this.direction = 'W';
                break;
            case 'W':
                this.direction = 'S';
                break;
            case 'E':
                this.direction = 'N';
                break;
            case 'S':
                this.direction = 'E';
                break;

        }

    }

}
