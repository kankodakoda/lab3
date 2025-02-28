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
    private final int frameWidth = 800;
    private final int frameHeight = 800;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    Timer timer;
    CarMovementHandler movementHandler;
    CarInputHandler inputHandler;
    CarUpdateManager updateManager;
    LoadingHandler loadingHandler;
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    ArrayList<Vehicle> vehicles;
    Workshop<Volvo240> volvoWorkshop = new Workshop<>(10, 300, 0);

    public CarController() {
        vehicles = new ArrayList<>();
        frame = new CarView("CarSim 1.0", this, frameWidth, frameHeight);
        movementHandler = new CarMovementHandler(vehicles, frameWidth, frameHeight);
        inputHandler = new CarInputHandler(movementHandler);
        loadingHandler = new LoadingHandler(vehicles, volvoWorkshop);
        updateManager = new CarUpdateManager(movementHandler, frame.drawPanel, loadingHandler);
        volvoWorkshop = new Workshop<>(10, 300, 0);
    }
}
