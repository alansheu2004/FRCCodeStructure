package frc.robot;

import frc.robot.actions.Action;
import frc.robot.subsystems.Subsystem;
import frc.robot.triggers.Trigger;

import java.util.ArrayList;

public class RobotManager {
    //Declare all subsystems here

    private Subsystem[] subsystems;

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

    private ArrayList<Action> actionQueue;

    public RobotManager() {
        //Instantiate all subsystems here

        subsystems = new Subsystem[] {
            //List all subsystems here
        };

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

        actionQueue = new ArrayList<Action>();
    }

    public void robotInit() {
        
    }

    public void robotPeriodic() {
        triggerLoop(robotTriggers);
        actionLoop();
    }

    public void autonomousInit() {
        
    }

    public void autonomousPeriodic() {
        triggerLoop(autonomousTriggers);
        actionLoop();
    }

    public void teleopInit() {
        
    }

    public void teleopPeriodic() {
        triggerLoop(teleopTriggers);
        actionLoop();
    }

    private void triggerLoop(Trigger[] triggers) {
        for (Trigger trigger : triggers) {
            if (trigger.triggered()) {
                actionQueue.add(trigger.getAction());
            }
        }
    }

    private void actionLoop() {
        for (Action action : actionQueue) {
            switch(action.getState()) {
                case IDLE:
                case BLOCKED:
                    action.start();
                case RUNNING:
                    action.loop();
                case DONE:
                    actionQueue.remove(action);
            }
        } 
    }
}