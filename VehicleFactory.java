public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType type, int x, int y) {
        return switch (type) {
            case VOLVO -> new Volvo240(x, y);
            case SAAB -> new Saab95(x, y);
            case SCANIA -> new Scania(x, y);
            case MERCEDES -> new Mercedes(x, y);
        };
    }
}
