import java.lang.reflect.Array;
import java.util.ArrayList;

public class CarInputHandler {
    CarMovementHandler movementHandler;

    public CarInputHandler(CarMovementHandler movementHandler) {
        this.movementHandler = movementHandler;
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        movementHandler.gas(gas);
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        movementHandler.brake(brake);

    }

    void setTurboOn() {
        movementHandler.setTurboOn();
    }

    void setTurboOff() {
        movementHandler.setTurboOff();
    }

    void raiseRamp(double amount) {
        movementHandler.raiseRamp(amount);
    }

    void lowerRamp(double amount) {
        movementHandler.lowerRamp(amount);
    }

    void startAllCars() {
        movementHandler.startAllCars();
    }

    void stopAllCars() {
        movementHandler.stopAllCars();
    }
}
