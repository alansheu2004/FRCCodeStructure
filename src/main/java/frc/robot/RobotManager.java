package frc.robot;

import frc.robot.actions.Action;
import frc.robot.subsystems.Subsystem;
import frc.robot.triggers.Trigger;

import java.util.Queue;

public class RobotManager {
    //Declare all subsystems here


    //Actions that should trigger at the beginning of each specified match period
    private Action[] robotInitActions;
    private Action[] autonomousInitActions;
    private Action[] teleopInitActions;

    //Actions that should happen continuously if there is no active action in that subsystem
    private Action[] robotPeriodicActions; 
    private Action[] autonomousPeriodicActions;
    private Action[] teleopPeriodicActions;

    //Triggers that will cause an action in the given match period
    private Trigger[] robotTriggers; 
    private Trigger[] autonomousTriggers;
    private Trigger[] teleopTriggers;

    public RobotManager() {
        //Instantiate all subsystems here


        robotInitActions = new Action[] {

        };

        autonomousInitActions = new Action[] {
            
        };

        teleopInitActions = new Action[] {
            
        };

        robotPeriodicActions = new Action[] {

        };

        autonomousPeriodicActions = new Action[] {
            
        };

        teleopPeriodicActions = new Action[] {
            
        };

        robotTriggers = new Trigger[] {

        };

        autonomousTriggers = new Trigger[] {

        };

        teleopTriggers = new Trigger[] {

        };
    }

    public void robotInit() {
        
    }

    public void robotPeriodic() {
        
    }

    public void autonomousInit() {
        
    }

    public void autonomousPeriodic() {
        
    }

    public void teleopInit() {
        
    }

    public void teleopPeriodic() {
        
    }
}