package frc.robot;

import frc.robot.actions.Action;
import frc.robot.actions.ContinuousAction;
import frc.robot.subsystems.*;
import frc.robot.triggers.Trigger;

import java.util.ArrayList;

public class RobotManager {
    //Declare all subsystems here
    

    //Actions that should trigger at the beginning of each specified match period
    private Action[] robotInitActions;
    private Action[] autonomousInitActions;
    private Action[] teleopInitActions;

    //Actions that should happen continuously if there is no active action in that subsystem
    private ContinuousAction[] robotContinuousActions;
    private ContinuousAction[] autonomousContinuousActions;
    private ContinuousAction[] teleopContinuousActions;

    //Triggers that will cause an action in the given match period
    private Trigger[] autonomousTriggers;
    private Trigger[] teleopTriggers;

    private ArrayList<Action> actionQueue;

    public RobotManager() {
        //Instantiate all subsystems here


        robotInitActions = new Action[] {
            
        };

        autonomousInitActions = new Action[] {
            
        };

        teleopInitActions = new Action[] {
            
        };

        robotContinuousActions = new ContinuousAction[] {
            
        };

        autonomousContinuousActions = new ContinuousAction[] {
            
        };

        teleopContinuousActions = new ContinuousAction[] {
            
        };

        autonomousTriggers = new Trigger[] {

        };

        teleopTriggers = new Trigger[] {

        };

        actionQueue = new ArrayList<Action>();
    }

    public void robotInit() {
        for (Action action : robotInitActions) {
            actionQueue.add(action);
        }
    }

    public void robotPeriodic() {
        actionLoop();
        continuousActionLoop(robotContinuousActions);
    }

    public void autonomousInit() {
        for (Action action : autonomousInitActions) {
            actionQueue.add(action);
        }
    }

    public void autonomousPeriodic() {
        triggerLoop(autonomousTriggers);
        actionLoop();
        continuousActionLoop(autonomousContinuousActions);
    }

    public void teleopInit() {
        for (Action action : teleopInitActions) {
            actionQueue.add(action);
        }
    }

    public void teleopPeriodic() {
        triggerLoop(teleopTriggers);
        actionLoop();
        continuousActionLoop(teleopContinuousActions);
    }

    private void triggerLoop(Trigger[] triggers) {
        for (Trigger trigger : triggers) {
            if (trigger.getTriggerSet()) {
                trigger.resetTrigger();
            }

            if (trigger.getTriggerSet() && trigger.triggered()) {
                try {
                    actionQueue.add((Action) trigger.getAction().clone());
                } catch (CloneNotSupportedException e) {
                    System.err.println("Something went wrong with cloning actions!");
                    System.err.println(e.getStackTrace());
                }
            }
        }
    }

    private void actionLoop() {
        ArrayList<Action> actionsDone = new ArrayList<>();
        for (Action action : actionQueue) {
            switch(action.getState()) {
                case IDLE:
                case BLOCKED:
                    action.start();
                case RUNNING:
                    action.loop();
                case DONE:
                    actionsDone.add(action);
            }
        }
        actionQueue.removeAll(actionsDone);
    }

    private void continuousActionLoop(ContinuousAction[] actions) {
        for (ContinuousAction action : actions) {
            switch(action.getState()) {
                case RUNNING:
                    if(action.getSubsystem().getCurrentAction() == null) {
                        action.loop();
                    }
                case IDLE:
                case BLOCKED:
                case DONE:
                    // Do nothing...
            }
        }
    }
}