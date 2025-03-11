import javax.swing.*;
import java.util.ArrayList;

public class CarController {

    private final int delay = 2;
    private final int frameWidth = 800;
    private final int frameHeight = 800;

    Timer timer;
    VehicleManager vehicleManager;
    CarMovementHandler movementHandler;
    CarInputHandler inputHandler;
    CarUpdateManager updateManager;
    LoadingHandler loadingHandler;
    CollisionHandler collisionHandler;
    CarView frame;
    ArrayList<Vehicle> vehicles;

    public CarController() {
        vehicles = new ArrayList<>();
        vehicleManager = new VehicleManager(vehicles);
        movementHandler = new CarMovementHandler(vehicles, frameWidth, frameHeight);
        frame = new CarView("CarSim 1.0", this, frameWidth, frameHeight, movementHandler);
        inputHandler = new CarInputHandler(movementHandler, vehicleManager);
        loadingHandler = new LoadingHandler(vehicles, vehicleManager.volvoWorkshop);
        collisionHandler = new CollisionHandler(frame.drawPanel, vehicles);
        updateManager = new CarUpdateManager(movementHandler, frame.drawPanel, loadingHandler, collisionHandler);
    }

}
