import java.awt.*;
import java.util.HashMap;

public class Workshop<T extends Car> {
    private final int capacity; // Max antal bilar verkstaden kan ta
    private HashMap<T,T> vehicles;
    private double xpos;
    private double ypos;

    public Workshop(int capacity, int xpos, int ypos) {
        this.capacity = capacity;
        this.xpos = xpos;
        this.ypos = ypos;
        vehicles = new HashMap<>();
    }

    public double getXpos() { return xpos; }

    public double getYpos() { return ypos; }

    public int getCapacity() {
        return capacity;
    }

    public HashMap<T,T> getVehicles() {
        return vehicles;
    }

    // Lägg till ett fordon i verkstaden
    public void addVehicle(T vehicle) {
        if (vehicles.size() >= capacity)
            System.out.println("Workshop is full. " + vehicle);
        else {
            vehicles.put(vehicle, vehicle);
            vehicle.setIsLoadedTrue();
            System.out.println(vehicle + " added to the workshop.");
        }
    }

    // Ta bort ett fordon från verkstaden
    public T removeVehicle(T vehicle) {
        if (!vehicles.isEmpty()) {
            T t = vehicles.remove(vehicle);
            vehicle.setIsLoadedFalse();
            System.out.println(vehicle + " removed from the workshop.");
            return t;
        } else {
            System.out.println("No vehicles in the workshop.");
            return null;
        }
    }

    // Visa alla fordon i verkstaden
    public void listVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the workshop.");
        } else {
            System.out.println("Vehicles in the workshop:");
            for (T vehicle : vehicles.values()) {
                System.out.println("- " + vehicle.getModelName());
            }
        }
    }


    public int countVehicles(){
        return vehicles.size();
    }

}
