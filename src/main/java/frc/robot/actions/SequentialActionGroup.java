package frc.robot.actions;

public class SequentialActionGroup implements Action {
    private Action[] actions;
    private int currentAction;

    public SequentialActionGroup(Action... actions) {
        this.actions = actions;
        currentAction = 0;
    }

    public ActionState getState() {
        if (currentAction == 0 && actions[currentAction].getState() =)
    }
    
    public void start() {
        actions[currentAction].start();
    }

    public void loop() {
        switch(actions[currentAction].getState()) {
            case RUNNING:
                actions[currentAction].loop();

            case BLOCKED:
                actions[currentAction].start();

            case DONE:
                currentAction++;
                if(currentAction >= actions.length) { break; }
                actions[currentAction].start();

            case IDLE:
                //Do Nothing...
                
            default:
                System.out.println("Something's wrong with Sequential Action States!");
        }
    }
}