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

    // The delay (ms) corresponds to 10 updates a sec (hz)
    private final int delay = 2;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    Timer timer;
    CarMovementHandler movementHandler;
    CarInputHandler inputHandler;
    CarUpdateManager updateManager;
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    ArrayList<Vehicle> vehicles;
    Workshop<Volvo240> volvoWorkshop;

    public CarController() {
        vehicles = new ArrayList<>();
        timer = new Timer(delay, new TimerListener());
        movementHandler = new CarMovementHandler();
        inputHandler = new CarInputHandler(vehicles);
        updateManager = new CarUpdateManager();
        volvoWorkshop = new Workshop<>(10, 300, 0);
    }
    //methods:

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getXPosition());
                int y = (int) Math.round(vehicle.getYPosition());
                if (isCarCollidingWithFrame(vehicle)) {
                    vehicle.turnLeft(180);
                }

                if (vehicle instanceof Volvo240) {
                    if (isVolvoWithinRange((Volvo240) vehicle, volvoWorkshop) &&
                        !volvoWorkshop.getVehicles().containsKey(vehicle)) {
                        volvoWorkshop.addVehicle((Volvo240) vehicle);
                        vehicle.stopEngine();
                    }
                }
                frame.drawPanel.moveit(x, y, vehicle);
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


}
