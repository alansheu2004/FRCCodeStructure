package frc.robot.actions;

public interface Action {
    public abstract void start();

    public abstract void loop();

    public abstract boolean isComplete();
}