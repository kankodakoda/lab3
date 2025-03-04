import javax.swing.*;
import java.util.ArrayList;

public class CarController {

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
    CollisionHandler collisionHandler;
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    ArrayList<Vehicle> vehicles;
    Workshop<Volvo240> volvoWorkshop = new Workshop<>(10, 300, 0);

    public CarController() {
        vehicles = new ArrayList<>();
        movementHandler = new CarMovementHandler(vehicles, frameWidth, frameHeight);
        frame = new CarView("CarSim 1.0", this, frameWidth, frameHeight, movementHandler);
        inputHandler = new CarInputHandler(movementHandler);
        loadingHandler = new LoadingHandler(vehicles, volvoWorkshop);
        collisionHandler = new CollisionHandler(frame.drawPanel, vehicles);
        updateManager = new CarUpdateManager(movementHandler, frame.drawPanel, loadingHandler, collisionHandler);
        volvoWorkshop = new Workshop<>(10, 300, 0);
    }
}
