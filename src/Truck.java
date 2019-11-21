public abstract class Truck extends Transport {

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

    public void gas(double amount) {
        if (amount < 0.0 || amount > 1.0) {
            throw new RuntimeException("The gas can't go above 1 nor below 0");
        }
        if (this.truckAngle > 0 || ramp == false) {
            throw new RuntimeException("Cannot move the truck when the truckbed is not in the down position!");
        }
        incrementSpeed(amount);

    }
}
