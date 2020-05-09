package frc.robot.triggers;

import frc.robot.actions.Action;
import edu.wpi.first.wpilibj.Joystick;

public class JoystickAxisTrigger extends Trigger {
    private Joystick joystick;
    private int axisId;
    private double threshold;

    private boolean alreadyTriggered;

    public JoystickAxisTrigger(Action action, Joystick joystick, int axisId, double threshold) {
        super(action);
        this.joystick = joystick;
        this.axisId = axisId;
        this.threshold = threshold;
        this.alreadyTriggered = false;
    }

    public JoystickAxisTrigger(Action action, Joystick joystick, int axisId) {
        this(action, joystick, axisId, 0.5);
    }

    public boolean triggered() {
        if (!alreadyTriggered) {
            if (threshold >= 0 && joystick.getRawAxis(axisId) >= threshold) {
                alreadyTriggered = true;
                return true;
            } else if (threshold < 0 && joystick.getRawAxis(axisId) <= threshold) {
                alreadyTriggered = true;
                return true;
            } else {
                return false;
            }
        } else {
            if (threshold >= 0 && joystick.getRawAxis(axisId) < threshold) {
                alreadyTriggered = false;
            } else if (threshold < 0 && joystick.getRawAxis(axisId) > threshold) {
                alreadyTriggered = false;
            }
            return false;
        }
        
    }
}