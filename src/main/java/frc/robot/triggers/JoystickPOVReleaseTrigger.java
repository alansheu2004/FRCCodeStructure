package frc.robot.triggers;

import frc.robot.actions.Action;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickPOVReleaseTrigger extends Trigger {
    private Joystick joystick;
    private int povId;
    private int angle;

    private boolean pressed;

    public JoystickPOVReleaseTrigger(Action action, Joystick joystick, int povId, int angle) {
        super(action);
        this.joystick = joystick;
        this.povId = povId;
        this.angle = angle;
        this.pressed = false;
    }

    public JoystickPOVReleaseTrigger(Action action, Joystick joystick, int angle) {
        this(action, joystick, 0, angle);
    }

    public boolean triggered() {
        if (!pressed) {
            if (joystick.getPOV(povId) == angle) {
                pressed = true;
            }
            return false;
        } else {
            if (joystick.getPOV(povId) == -1) {
                pressed = false;
                return true;
            }
            return false;
        }
    }
}