package frc.robot.actions;

public abstract class Action implements Cloneable {
    public abstract void start();

    public abstract void loop();

    public abstract ActionState getState();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Action) super.clone();
    }

    public static enum ActionState {
        IDLE,
        BLOCKED,
        RUNNING,
        DONE
    }
}