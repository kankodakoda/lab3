import java.util.ArrayList;

public class CollisionHandler {
    DrawPanel drawPanel;
    ArrayList<Vehicle> vehicles;

    public CollisionHandler(DrawPanel drawPanel, ArrayList<Vehicle> vehicles) {
        this.drawPanel = drawPanel;
        this.vehicles = vehicles;
    }

    public void handleFrameCollision() {
        for (Vehicle vehicle : vehicles) {
            if (isCarCollidingWithFrame(vehicle)) {
                vehicle.turnLeft(180);
            }
        }
    }

    private boolean isCarCollidingWithFrame(Vehicle car) {
        return car.getXPosition() > drawPanel.getWidth() - 115 ||
                car.getXPosition() < 0 ||
                car.getYPosition() > drawPanel.getWidth() - 310 ||
                car.getYPosition() < 0;
    }
}
