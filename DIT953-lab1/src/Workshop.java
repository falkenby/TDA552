import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Workshop implements Storage {

    private int storageMax; // Storage max of the workshop
    protected ArrayList<Car> cars; // An array for the cars to be in
    private Type carType; // To make it easier for the workshop to identify the different cars

    /**
     * A constructor to initialize the workshop
     * @param storageMax
     * @param carType
     */
    public Workshop(int storageMax, Type carType) {

        this.storageMax = storageMax;
        this.cars = new ArrayList<Car>(storageMax);
        this.carType = carType;
    }

    /**
     * An enum method for the different cars
     */
    public enum Type {
        VOLVO,
        SAAB,
        ALL;
    }

    /* Getter for the car */
    public Car getCarInfo(Car c){
        return c;
    }

    /**
     * A method for adding a car to the storage
     * It checks if the is storage available
     * A switch is used to make sure the right car goes to the right storage
     * @param c
     */
    @Override
    public void addCar(Car c) {

        if (cars.size() == (storageMax - 1)) {
            throw new RuntimeException("There isn't any room!!");
        }

        switch (this.carType) {
            case ALL:
                cars.add(c);
                c.stopEngine();
                c.state = Transport.StateEngine.TRANSPORTING;
                break;
            case SAAB:
                if (c.type != Type.SAAB) {
                    throw new RuntimeException("Sorry! This workshop only accepts SAAB cars!");
                }
                cars.add(c);
                c.stopEngine();
                c.state = Transport.StateEngine.TRANSPORTING;
                break;
            case VOLVO:
                if (c.type != Type.VOLVO) {
                    throw new RuntimeException("Sorry! This workshop only accepts VOLVO cars!");
                }
                cars.add(c);
                c.stopEngine();
                c.state = Transport.StateEngine.TRANSPORTING;
                break;
        }

    }

    /**
     * Checks out a car and then returns the information of said car in full detail
     * @param index
     * @return
     */
    public Car checkOutCar(int index) {

        Car carTemp = getCarInfo(cars.get(index));
        cars.remove(index);
        return carTemp;

    }

    /**
     * Sets the cars position to the same as the workshop
     * @param point
     */

    private void setCarsPosition(Point2D.Double point) {

        for (Car c : getCars()) {
            c.point.setLocation(point);
        }
    }

    /* Just a getter for the cars */
    public ArrayList<Car> getCars() {
        return cars;
    }
}
