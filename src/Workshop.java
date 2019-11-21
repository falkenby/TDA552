import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Workshop {

    private double storageMax;
    private ArrayList<Car> cars;
    private Point2D.Double carsPosition;

    /**
     * Creates a new arraylist for the cars
     */
    public Workshop(int carMax) {
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

    public void addCar(Car c){
        if(cars.size() == (storageMax-1){
            throw new RuntimeException("There isn't any room!!");
        }
        cars.add(c);
    }

    public void unloadTruck(){

    }

    public void checkOutCar(int index){
        

    }

    public void setCarsPosition(Point2D.Double point) {
        this.carsPosition = point;

        for (Car c : getCars()) {
            c.setCarsPosition(point);
        }
    }

    public ArrayList<Car> getCars(){
        return cars;
    }


}
