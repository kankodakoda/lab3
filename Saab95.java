import java.awt.*;

public class Saab95 extends Car {

    private TurboState turboState;

    public Saab95(double xpos, double ypos) {
        super("Saab95", 2, 125, Color.red, xpos, ypos);
        this.turboState = new TurboOffState();
    }

    public void setTurboState(TurboState state) {
        this.turboState = state;
    }

    public void activateTurbo() {
        turboState.activateTurbo(this);
    }

    public void deactivateTurbo() {
        turboState.deactivateTurbo(this);
    }

    @Override
    public double speedFactor() {
        double turbo = turboState.getSpeedFactor();
        return getEnginePower() * 0.01 * turbo;
    }
}
