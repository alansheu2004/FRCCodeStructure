package frc.robot.subsystems;

import frc.robot.actions.Action;

public abstract class Subsystem {
    private Action currentAction;

    public abstract void init();

    public abstract void loop();

    public final void setCurrentAction(Action action) {
        currentAction = action;
    }

    public final Action getCurrentAction() {
        return currentAction;
    }
}