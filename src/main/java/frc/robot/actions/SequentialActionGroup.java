package frc.robot.actions;

public class SequentialActionGroup extends Action {
    private Action[] actions;
    private int currentAction;
    private ActionState state;

    public SequentialActionGroup(Action... actions) {
        this.actions = actions;
        currentAction = 0;
        state = ActionState.IDLE;
    }

    public ActionState getState() {
        return state;
    }
    
    public void start() {
        actions[currentAction].start();
        this.state = actions[currentAction].getState();
    }

    public void loop() {
        switch(actions[currentAction].getState()) {
            case BLOCKED:
                actions[currentAction].start();
            case RUNNING:
                actions[currentAction].loop();
            case DONE:
                currentAction++;
                if(currentAction >= actions.length) { 
                    state = ActionState.DONE;
                    break;
                }
                actions[currentAction].start();
            case IDLE:
                //Do Nothing...
                
            default:
                System.out.println("Something's wrong with Sequential Action States!");
        }
    }
}