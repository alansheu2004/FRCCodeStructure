package frc.robot;

import frc.robot.actions.Action;
import frc.robot.subsystems.Subsystem;
import frc.robot.triggers.Trigger;
import frc.robot.util.MatchPeriod;

public class Scheduler {
    private Subsystem[] subsystems;

    public MatchPeriod period;

    private Action[] robotInitActions;
    private Action[] autonomousInitActions;
    private Action[] teleopInitActions;

    private Trigger[] robotTriggers;
    private Trigger[] autonomousTriggers;
    private Trigger[] teleopTriggers;


    private static Scheduler instance;

    public Scheduler() {
        subsystems = new Subsystem[] {
            //List subsystem instances here
        };

        
    }

    public void loop() {

    }

    public static Scheduler getInstance() {
        return instance;
    }
}