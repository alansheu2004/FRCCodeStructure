package frc.robot.actions;

import frc.robot.subsystems.Subsystem;

public abstract class ContinuousAction extends Action {
    private Subsystem subsystem;
    private ActionState state;

    protected ContinuousAction(Subsystem subsystem) {
        this.subsystem = subsystem;
        state = ActionState.IDLE;
    }

    public final Subsystem getSubsystem() {
        return subsystem;
    } 

    public final ActionState getState() {
        return state;
    }

    public final void start() {
        if(subsystem.setContinuousAction(this)) {
            state = ActionState.RUNNING;
        } else {
            state = ActionState.BLOCKED;
        }
    }

    public abstract void loop();
}