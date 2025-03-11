import java.util.ArrayList;

public class CarMovementHandler extends VehicleObservable {
    ArrayList<Vehicle> vehicles;
    int frameWidth;
    int frameHeight;

    public CarMovementHandler(ArrayList<Vehicle> vehicles, int frameWidth, int frameHeight) {
        this.vehicles = vehicles;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    public void moveCars() {
        for (Vehicle vehicle : vehicles)
            vehicle.move();
        notifyObservers();
    }

    public void gas(double amount) {
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(amount);
        }
    }

    public void brake(double amount) {
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(amount);
        }
    }

    void setTurboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95)
                ((Saab95) vehicle).activateTurbo();
        }

    }

    void setTurboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95)
                ((Saab95) vehicle).deactivateTurbo();
        }
    }

    void raiseRamp(double amount) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania)
                ((Scania) vehicle).raiseRamp(amount);
        }
    }

    void lowerRamp(double amount) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).lowerRamp(amount);
            }
        }
    }

    void startAllCars() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopAllCars() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }


}
