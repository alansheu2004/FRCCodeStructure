package frc.robot.subsystems;

import frc.robot.actions.SingleAction;
import frc.robot.RobotManager;

public abstract class Subsystem {
    private SingleAction currentAction;
    private SingleAction continuousAction;

    protected RobotManager manager;

    public Subsystem(RobotManager manager) {
        this.manager = manager;
    }

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

    public final void clearCurrentAction() {
        currentAction = null;
    }

    public final boolean setContinuousAction(SingleAction action) {
        if(continuousAction == null) {
            this.continuousAction = action;
            return true;
        } else {
            return false;
        }
    }

    public final SingleAction getContinuousAction() {
        return continuousAction;
    }

    public final void clearContinuousAction() {
        continuousAction = null;
    }
}