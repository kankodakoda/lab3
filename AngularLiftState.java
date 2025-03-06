public class AngularLiftState implements LiftState {

    @Override
    public void raiseRamp(RampAbility ramp, double amount) {
        if (ramp instanceof AngularLift) {
            ((AngularLift) ramp).raiseRamp(amount);
            System.out.println("Raised ramp to " + ((AngularLift) ramp).getRampAngle());
        }
    }

    @Override
    public void lowerRamp(RampAbility ramp, double amount) {
        if (ramp instanceof AngularLift) {
            ((AngularLift) ramp).lowerRamp(amount);
            System.out.println("Lowered ramp to " + ((AngularLift) ramp).getRampAngle());
        }
    }

    @Override
    public boolean isRaised(RampAbility ramp) {
        return ramp instanceof AngularLift && ((AngularLift) ramp).getRampAngle() > 0;
    }
}
