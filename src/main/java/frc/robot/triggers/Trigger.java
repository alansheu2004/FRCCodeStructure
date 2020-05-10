package frc.robot.triggers;

import frc.robot.actions.Action;

public abstract class Trigger {
    private final Action action;
    protected boolean triggerSet;

    protected Trigger(Action action, boolean triggerSet) {
        this.action = action;
        this.triggerSet = triggerSet;
    }

    protected Trigger(Action action) {
        this(action, true);
    }

    //Returns whether the action should be triggered
    //Can set triggerSet to false
    public abstract boolean triggered();

    //Only called when triggerSet is false
    //Should set triggerSet to true if condition met
    public void resetTrigger() {
        //OVERRIDE ME
        triggerSet = true;
    };

    public final Action getAction() {
        return action;
    }

    public final boolean getTriggerSet() {
        return triggerSet;
    }
}