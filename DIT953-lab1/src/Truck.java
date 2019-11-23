
public abstract class Truck extends Transport {

    protected StateRamp stateRamp;

    public enum StateRamp{
        UP,
        DOWN;
    }

    public double getAngle() {
        return truckAngle;
    }

    public StateRamp isRampDown() {
        return this.stateRamp;
    }

    /**
     * A method for raising the truckbed
     *
     * @param angle
     */
    public abstract void raiseTruckBed(double angle);

    /**
     * A method for lowering the truckbed
     *
     * @param angle
     */

    public abstract void lowerTruckBed(double angle);

    /**
     * Speeding up the car, amount must be between 0 and 1
     * Also catches if the truck has an truckangle of more than 0
     */

    @Override
    public void gas(double amount) {
        if (amount < 0.0 || amount > 1.0) {
            throw new RuntimeException("The gas can't go above 1 nor below 0");
        }
        if (this.stateRamp == StateRamp.UP) {
            throw new RuntimeException("Cannot move the truck when the truckbed is not in the down position!");
        }
        incrementSpeed(amount);
        this.state = StateEngine.TRANSPORTING;


    }


}
