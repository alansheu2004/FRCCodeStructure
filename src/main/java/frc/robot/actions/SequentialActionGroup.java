package frc.robot.actions;

public class SequentialActionGroup extends Action {
    private Action[] actions;
    private int currentAction;

    public SequentialActionGroup(Action... actions) {
        this.actions = actions;
        currentAction = 0;
    }
    
    public void start() {
        actions[currentAction].start();
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