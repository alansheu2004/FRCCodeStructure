package frc.robot.actions;

import java.util.*;

public class ParallelActionGroup implements Action {
    private HashMap<Action, Boolean> actionStates; //Whether the actions are finished

    public ParallelActionGroup(SingleAction... actions) {
        this.actions = actions;
        actionsDone = 0;
    }

    private ParallelActionGroup() {

    }
    
    public void start() {
        actions[].start();
    }

    public void loop() {
        if(actions[currentAction].isComplete()) {
            currentAction++;
            actions[currentAction].start();
        }

        if (currentAction < actions.length) {
            actions[currentAction].loop();
        }

    }

    public boolean isComplete() {
        return currentAction >= actions.length;
    }
}