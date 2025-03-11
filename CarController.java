import java.util.ArrayList;

public class CarController {

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
        int frameWidth = 800;
        int frameHeight = 800;
        movementHandler = new CarMovementHandler(vehicles, frameWidth, frameHeight);
        frame = new CarView("CarSim 1.0", this, frameWidth, frameHeight, movementHandler);
        inputHandler = new CarInputHandler(movementHandler, vehicleManager);
        loadingHandler = new LoadingHandler(vehicles, vehicleManager.volvoWorkshop);
        collisionHandler = new CollisionHandler(frame.drawPanel, vehicles);
        updateManager = new CarUpdateManager(movementHandler, loadingHandler, collisionHandler);
    }

}
