package frc.robot.triggers;

import frc.robot.actions.Action;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickPOVPressTrigger extends Trigger {
    private Joystick joystick;
    private int povId;
    private int angle;

    private boolean alreadyTriggered;

    public JoystickPOVPressTrigger(Action action, Joystick joystick, int povId, int angle) {
        super(action);
        this.joystick = joystick;
        this.povId = povId;
        this.angle = angle;
        this.alreadyTriggered = false;
    }

    public JoystickPOVPressTrigger(Action action, Joystick joystick, int angle) {
        this(action, joystick, 0, angle);
    }

    public boolean triggered() {
        if (!alreadyTriggered) {
            alreadyTriggered = true;
            return joystick.getPOV(povId) == angle;
        } else {
            if (joystick.getPOV(povId) == -1) {
                alreadyTriggered = false;
            }
            return false;
        }
    }
}