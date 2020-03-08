package frc.robot.actions;

import frc.robot.subsystems.Subsystem;

public abstract class SingleAction extends Action {
    private Subsystem subsystem;
    private ActionState state;

    protected SingleAction(Subsystem subsystem) {
        this.subsystem = subsystem;
        state = ActionState.IDLE;
    }

    public final Subsystem getSubsystem() {
        return subsystem;
    } 

    public final ActionState getState() {
        return state;
    }

    protected final void setDone() {
        state = ActionState.DONE;
        subsystem.clearCurrentAction();
    }

    public final void start() {
        if(subsystem.setCurrentAction(this)) {
            state = ActionState.RUNNING;
            init();
        } else {
            state = ActionState.BLOCKED;
        }
    }

    public abstract void init();

    public abstract void loop();
}