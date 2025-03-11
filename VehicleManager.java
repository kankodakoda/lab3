import java.util.ArrayList;

public class VehicleManager {
    ArrayList<Vehicle> vehicles;
    private int maxVehicleCount = 5;
    private int currentYposition = 0;
    final Workshop<Volvo240> volvoWorkshop;

    public VehicleManager(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
        volvoWorkshop = new Workshop<>(5, 400, 0);
    }

    public void addVehicle (VehicleType vehicleType) {
        if (vehicles.size() < maxVehicleCount) {
            Vehicle vehicle = VehicleFactory.createVehicle(vehicleType, currentYposition);
            vehicles.add(vehicle);
            System.out.println(vehicle + " added to vehicles");
            currentYposition += 100;
        }
        else
            System.out.println("Max capacity reached");
    }

    public void removeVehicle() {
        if (!vehicles.isEmpty()) {
            vehicles.remove(vehicles.size() - 1);
            System.out.println("Last vehicle removed");
            currentYposition -= 100;
            System.out.println("ypos decremented by 100");
        }
        else
            System.out.println("There are no vehicles to remove");
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
