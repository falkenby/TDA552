import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class StorageTest {

    @Test(expected = RuntimeException.class)
    public void addCarError() {

        Workshop workshop = new Workshop(2, Workshop.Type.SAAB);
        Volvo240 myCar = new Volvo240();
        workshop.addCar(myCar);
    }

    @Test
    public void addCarWorkshop() {

        Workshop workshop = new Workshop(2, Workshop.Type.VOLVO);
        Volvo240 myCar = new Volvo240();
        workshop.addCar(myCar);
        assertEquals(workshop.cars.contains(myCar), true);
    }

    @Test
    public void addCarCarTruck() {

        CarTruck truck = new CarTruck(2);
        Volvo240 myCar = new Volvo240();
        truck.addCar(myCar);
        assertEquals(truck.cars.contains(myCar), true);
    }

    @Test
    public void setCarPosition(){

        Workshop workshop = new Workshop(2, Workshop.Type.VOLVO);
        Volvo240 myCar = new Volvo240();
        workshop.addCar(myCar);
        Point2D.Double point = new Point2D.Double(2,2);
        workshop.setCarsPosition(point);
        assertEquals(point, workshop.cars.get(0).point);
    }

    @Test
    public void checkOutCar() {

        Workshop workshop = new Workshop(2, Workshop.Type.VOLVO);
        Volvo240 myCar = new Volvo240();
        workshop.addCar(myCar);
        workshop.checkOutCar(0);
        assertEquals(workshop.cars.isEmpty(), true);
    }

}
