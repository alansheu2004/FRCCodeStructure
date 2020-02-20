package frc.robot.actions;

public class ParallelActionGroup extends Action {
    private Action[] actions;
    private int actionsDone;

    public ParallelActionGroup(Action... actions) {
        this.actions = actions;
        actionsDone = 0;
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