package frc.robot.triggers;

import frc.robot.actions.Action;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickDpadPressTrigger extends Trigger {
    private Joystick joystick;
    private int povId;
    private int angle;

    private boolean alreadyTriggered;

    public JoystickDpadPressTrigger(Action action, Joystick joystick, int povId, int angle) {
        super(action);
        this.joystick = joystick;
        this.povId = povId;
        this.angle = angle;
        this.alreadyTriggered = false;
    }

    public JoystickDpadPressTrigger(Action action, Joystick joystick, int angle) {
        this(action, joystick, 0, angle);
    }

    public boolean triggered() {
        if (!alreadyTriggered && joystick.getPOV(povId) == angle) {
            alreadyTriggered = true;
            return true;
        } else {
            if (joystick.getPOV(povId) == -1) {
                alreadyTriggered = false;
            }
            return false;
        }
    }
}