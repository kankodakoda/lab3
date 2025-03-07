import java.util.ArrayList;

public class VehicleManager {
    ArrayList<Vehicle> vehicles;
    public VehicleManager(ArrayList<Vehicle> vehicles) { this.vehicles = vehicles; }

    public void addVehicle (VehicleType vehicleType, int x, int y) {
        Vehicle vehicle = VehicleFactory.createVehicle(vehicleType, x, y);
        vehicles.add(vehicle);
    }

    public void removeVehicle() {
        if (!vehicles.isEmpty())
            vehicles.remove(vehicles.size() - 1);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
