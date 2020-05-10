package frc.robot.triggers;

import frc.robot.actions.Action;
import edu.wpi.first.wpilibj.Joystick;

public class JoystickAxisTrigger extends Trigger {
    private Joystick joystick;
    private int axisId;
    private double threshold;

    public JoystickAxisTrigger(Action action, Joystick joystick, int axisId, double threshold) {
        super(action);
        this.joystick = joystick;
        this.axisId = axisId;
        this.threshold = threshold;
    }

    public JoystickAxisTrigger(Action action, Joystick joystick, int axisId) {
        this(action, joystick, axisId, 0.5);
    }

    public boolean triggered() {
        if (threshold >= 0 && joystick.getRawAxis(axisId)>=threshold) {
            triggerSet = false;
            return true;
        } else if (threshold < 0 && joystick.getRawAxis(axisId)<=threshold) {
            triggerSet = false;
            return true;
        } else {
            return false;
        }
    }

    public void resetTrigger() {
        if (threshold >= 0 && joystick.getRawAxis(axisId)<=threshold) {
            triggerSet = true;
        } else if (threshold < 0 && joystick.getRawAxis(axisId)>=threshold) {
            triggerSet = true;
        }
    }
}