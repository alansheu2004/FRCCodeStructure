package frc.robot.actions;

public abstract class Action {
    public abstract void start();

    public abstract void loop();

    public abstract boolean isComplete();
}