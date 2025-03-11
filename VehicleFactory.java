import java.util.Random;

public class VehicleFactory {

    public static Vehicle createVehicle(VehicleType type, int y) {
        return switch (type) {
            case VOLVO -> new Volvo240(0, y);
            case SAAB -> new Saab95(0, y);
            case SCANIA -> new Scania(0, y);
            case MERCEDES -> new Mercedes(0, y);
            case RANDOM -> {
                VehicleType[] types = {VehicleType.VOLVO, VehicleType.SAAB, VehicleType.SCANIA, VehicleType.MERCEDES};
                VehicleType randomType = types[new Random().nextInt(types.length)];
                yield createVehicle(randomType, y); // Recursively call with a random type
            }
        };
    }
}
