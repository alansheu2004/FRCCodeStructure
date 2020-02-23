package frc.robot.actions;

import frc.robot.subsystems.Subsystem;

public abstract class SingleAction implements Action {
    private Subsystem subsystem;

    public SingleAction(Subsystem subsystem) {
        this.subsystem = subsystem;
        
    }

    public Subsystem getSubsystem() {
        return subsystem;
    }

    public abstract void start();

    public abstract void loop();

    public abstract boolean isComplete();
}