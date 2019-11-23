import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;

public class CarTruck extends Truck implements Storage {

    protected double storageMax;
    protected ArrayList<Car> cars;
    protected Point2D.Double carsPosition;

    public CarTruck(int carMax) {
        nrDoors = 2;
        color = Color.green;
        enginePower = 0.9;
        modelName = "CarTruck";
        stopEngine();
        point = new Point2D.Double(0, 0);
        direction = 'N';
        state = StateEngine.STOPPED;
        stateRamp = StateRamp.DOWN;
        storageMax = carMax;
        this.cars = new ArrayList<Car>(carMax);

    }


    /**
     * Returns the current position of the cars,
     * for the CarTruck class to use
     *
     * @return
     */
    public Point2D.Double getCarsPosition() {
        return carsPosition;
    }

    /**
     * Speedfactor is unique for each vehicle
     *
     * @return
     */
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
        if (this.currentSpeed > 0) {
            throw new RuntimeException("Cannot raise truckbed when truck is moving!");
        }

        stateRamp = StateRamp.UP;

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

        stateRamp = StateRamp.DOWN;
    }

    /**
     * Method for adding a car to the carTruck
     * It checks if there is any room left on the truck
     * also checks that we are not trying to load the carTruck onto itself
     *
     * @param c
     */
    @Override
    public void addCar(Car c) {
        if (cars.size() == (storageMax - 1)) {
            throw new RuntimeException("There isn't any room!!");
        }

        if (c.modelName == "CarTruck") {
            throw new RuntimeException("CarTruck cannot load it self");
        }
        if ((c.point.getX() > (point.getX() + 10)) && (c.point.getY() > (point.getY() + 10))){
            throw new RuntimeException("The car is too far away!");
        }

        cars.add(c);
        c.stopEngine();
        c.state = StateEngine.TRANSPORTING;
    }

    /**
     * Unloading the truck
     * By using reverse on the arraylist, we get a First-in-Last-Out list
     * We also change the position of the car to outside of the truck
     */
    public void unloadTruck() {
        Collections.reverse(cars);
        stateRamp = StateRamp.DOWN;

        for (Car c : getCars()
        ) {
            c.point.setLocation((point.getX() - 10), (point.getY() - 10));
            c.state = StateEngine.STOPPED;
        }

    }

    /**
     * This method is to make sure the cars on the carTruck has the same position as the truck
     *
     * @param point
     */
    private void setCarsPosition(Point2D.Double point) {

        for (Car c : getCars()) {
            c.point.setLocation(point);
        }
    }

    @Override
    public void move(){
        super.move();
        setCarsPosition(point);
    }

    /* Just a getter for the cars */
    public ArrayList<Car> getCars() {
        return cars;
    }

}
