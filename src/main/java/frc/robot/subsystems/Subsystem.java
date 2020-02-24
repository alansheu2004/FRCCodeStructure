package frc.robot.subsystems;

import frc.robot.actions.SingleAction;

public abstract class Subsystem {
    private SingleAction currentAction;

    public abstract void init();

    public abstract void loop();

    //Returns true if there if successfully set the action. Returns false if there was already an action running
    public final boolean setCurrentAction(SingleAction action) {
        if(currentAction == null) {
            this.currentAction = action;
            return true;
        } else {
            return false;
        }
    }

    public final SingleAction getCurrentAction() {
        return currentAction;
    }
}