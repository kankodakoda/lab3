public class TurboOffState implements  TurboState {

    @Override
    public void activateTurbo(Saab95 saab) {
        saab.setTurboState(new TurboOnState());
    }

    @Override
    public void deactivateTurbo(Saab95 saab) {
        System.out.println("Turbo already deactivated");
    }

    @Override
    public float getSpeedFactor() {
        return 1;
    }
}
