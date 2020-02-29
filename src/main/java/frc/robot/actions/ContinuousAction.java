package frc.robot.actions;

public abstract class ContinuousAction extends SingleAction {

    public ContinuousAction(Subsystem)

    public abstract void start();

    public abstract void loop();



    public static enum ActionState {
        IDLE,
        BLOCKED,
        RUNNING,
        DONE
    }
}