import java.util.ArrayList;

public class LoadingHandler {
    private final ArrayList<Vehicle> vehicles;
    private final Workshop<Volvo240> volvoWorkshop;

    public LoadingHandler(ArrayList<Vehicle> vehicles, Workshop<Volvo240> volvoWorkshop) {
        this.vehicles = vehicles;
        this.volvoWorkshop = volvoWorkshop;
    }

    public void handleLoading() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Volvo240) {
                if (isVolvoWithinRange((Volvo240) vehicle, volvoWorkshop) &&
                        !volvoWorkshop.getVehicles().containsKey(vehicle)) {
                    volvoWorkshop.addVehicle((Volvo240) vehicle);
                    vehicle.stopEngine();
                }
            }
        }
    }
    private boolean isVolvoWithinRange(Volvo240 volvo, Workshop<Volvo240> workshop) {
        return volvo.getXPosition() > workshop.getXpos() - 10 &&
                volvo.getXPosition() < workshop.getXpos() + 10 &&
                volvo.getYPosition() > workshop.getYpos() - 10 &&
                volvo.getYPosition() < workshop.getYpos() + 10;
    }

}
