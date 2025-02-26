public class Main {
    public static void main(String[] args) {
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240(0, 0));
        cc.vehicles.add(new Saab95(0,100));
        cc.vehicles.add(new Scania(0,200));

        System.out.println(cc.inputHandler.getSize());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        // Start the timer
        cc.timer.start();
    }
}
