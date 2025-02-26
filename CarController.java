import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 10;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    Timer timer;
    CarMovementHandler movementHandler;
    CarInputHandler inputHandler;
    CarUpdateManager updateManager;
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles;
    Workshop<Volvo240> volvoWorkshop;

    public CarController() {
        timer = new Timer(delay, new TimerListener());
        movementHandler = new CarMovementHandler();
        inputHandler = new CarInputHandler();
        updateManager = new CarUpdateManager();
        vehicles = new ArrayList<>();
        volvoWorkshop = new Workshop<>(10, 300, 0);
    }
    //methods:

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : vehicles) {
                car.move();
                int x = (int) Math.round(car.getXPosition());
                int y = (int) Math.round(car.getYPosition());
                if (isCarCollidingWithFrame(car)) {
                    car.turnLeft(180);
                }

                if (car instanceof Volvo240) {
                    if (isVolvoWithinRange((Volvo240) car, volvoWorkshop) &&
                        !volvoWorkshop.getVehicles().containsKey(car)) {
                        volvoWorkshop.addVehicle((Volvo240) car);
                        car.stopEngine();
                    }
                }

                frame.drawPanel.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }

        private boolean isVolvoWithinRange(Volvo240 volvo, Workshop<Volvo240> workshop) {
            return volvo.getXPosition() > workshop.getXpos() - 10 &&
                   volvo.getXPosition() < workshop.getXpos() + 10 &&
                   volvo.getYPosition() > workshop.getYpos() - 10 &&
                   volvo.getYPosition() < workshop.getYpos() + 10;
        }

        private boolean isCarCollidingWithFrame(Vehicle car) {
            return car.getXPosition() > frame.getWidth() - 115 ||
                    car.getXPosition() < 0 ||
                    car.getYPosition() > frame.getHeight() - 310 ||
                    car.getYPosition() < 0;
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
       for (Vehicle car : vehicles) {
           car.gas(gas);
       }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.brake(brake);
        }
    }

    void setTurboOn() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOn();
        }

    }

    void setTurboOff() {
        for (Vehicle car : vehicles) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOff();
        }
    }

    void raiseRamp(double amount) {
        for (Vehicle car : vehicles) {
            if (car instanceof Scania)
                ((Scania) car).raiseRamp(amount);
        }
    }

    void lowerRamp(double amount) {
        for (Vehicle car : vehicles) {
            if (car instanceof Scania) {
                ((Scania) car).lowerRamp(amount);
            }
        }
    }

    void startAllCars() {
        for (Vehicle car : vehicles) {
            car.startEngine();
        }
    }

    void stopAllCars() {
        for (Vehicle car : vehicles) {
            car.stopEngine();
        }
    }

}
