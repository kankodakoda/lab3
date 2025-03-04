public class TurboOnState implements TurboState {
    @Override
    public void activateTurbo(Saab95 saab) {
        System.out.println("Turbo is already activated");
    }

    @Override
    public void deactivateTurbo(Saab95 saab) {
        saab.setTurboState(new TurboOffState());
    }

    @Override
    public float getSpeedFactor() {
        return 1.3f;
    }
}

