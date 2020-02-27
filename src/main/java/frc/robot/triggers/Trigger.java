package frc.robot.triggers;

import frc.robot.actions.Action;

public abstract class Trigger {
    private Action action;

    public Trigger(Action action) {
        this.action = action;
    }

    public abstract boolean triggered();
}