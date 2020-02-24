package frc.robot.actions;

public class ParallelActionGroup extends Action {
    private Action[] actions; //Whether the actions are finished

    public ParallelActionGroup(Action... actions) {
        this.actions = actions;
    }
    
    public void start() {
        ActionState tempState = ActionState.BLOCKED;
        for(Action action : actions) {
            action.start();
            if(action.state != ActionState.BLOCKED) {tempState = ActionState.RUNNING;}
        }
        this.state = tempState;
    }

    public void loop() {
        int doneCount = 0;

        for(Action action : actions) {
            switch(action.state) {
                case RUNNING:
                    action.loop();
                case BLOCKED:
                    action.start();
                case DONE:
                    doneCount++;
    
                case IDLE:
                    //Do Nothing...
                    
                default:
                    System.out.println("Something's wrong with Sequential Action States!");
            }
        }

        if(doneCount >= actions.length) {

        }
    }
}