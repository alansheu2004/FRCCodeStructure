package frc.robot.actions;

public class ParallelActionGroup extends Action {
    private Action[] actions; //Whether the actions are finished
    private ActionState state;

    public ParallelActionGroup(Action... actions) {
        this.actions = actions;
        state = ActionState.IDLE;
    }

    public ActionState getState() {
        return state;
    }
    
    public void start() {
        ActionState tempState = ActionState.BLOCKED;
        for(Action action : actions) {
            action.start();
            if(action.getState() != ActionState.BLOCKED) {
                tempState = ActionState.RUNNING;
            }
        }
        state = tempState;
    }

    public void loop() {
        int doneCount = 0;

        for(Action action : actions) {
            switch(action.getState()) {
                case BLOCKED:
                    action.start();
                case RUNNING:
                    action.loop();
                case DONE:
                    doneCount++;
                    if(doneCount >= actions.length) {
                        state = ActionState.DONE;
                    }
                case IDLE:
                    //Do Nothing...
                    
                default:
                    System.out.println("Something's wrong with Parallel Action States!");
            }
        }

        if(doneCount >= actions.length) {

        }
    }
}