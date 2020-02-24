package frc.robot.actions;

import frc.robot.subsystems.Subsystem;

public abstract class SingleAction implements Action {
    private Subsystem subsystem;
    private ActionState state;

    protected SingleAction(Subsystem subsystem) {
        this.subsystem = subsystem;
    }

    public final Subsystem getSubsystem() {
        return subsystem;
    }

    public final ActionState getState() {
        return state;
    }

    public void start() {
        if(subsystem.setCurrentAction(this)) {
            this.state = ActionState.RUNNING;
        } else {
            this.state = ActionState.BLOCKED;
        }
    }

    public abstract void loop();
}