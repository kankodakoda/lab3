public class Main {
    public static void main(String[] args) {
        CarController cc = new CarController();

        cc.vehicles.add(VehicleFactory.createVehicle(VehicleType.VOLVO, 0, 0));
        cc.vehicles.add(VehicleFactory.createVehicle(VehicleType.SAAB, 0, 100));
        cc.vehicles.add(VehicleFactory.createVehicle(VehicleType.SCANIA, 0, 200));

        // Start the timer
        cc.updateManager.start();
    }
}
