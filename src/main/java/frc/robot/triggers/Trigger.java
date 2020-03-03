package frc.robot.triggers;

import frc.robot.actions.Action;

public abstract class Trigger {
    private final Action action;

    protected Trigger(Action action) {
        this.action = action;
    }

    public abstract boolean triggered();

    public final Action getAction() {
        return action;
    }
}