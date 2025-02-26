import java.lang.reflect.Array;
import java.util.ArrayList;

public class CarInputHandler {
    ArrayList<Vehicle> vehicles;

    public CarInputHandler(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    int getSize() {
        return vehicles.size();
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    void setTurboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOn();
        }

    }

    void setTurboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOff();
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
