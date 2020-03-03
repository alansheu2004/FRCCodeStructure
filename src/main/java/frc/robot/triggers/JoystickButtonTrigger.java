package frc.robot.triggers;

import frc.robot.actions.Action;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickButtonTrigger extends Trigger {
    private Joystick joystick;
    private int buttonId;

    public JoystickButtonTrigger(Action action, Joystick joystick, int buttonId) {
        super(action);
         this.joystick = joystick;
         this.buttonId = buttonId;
    }

    public boolean triggered() {
        return joystick.getRawButton(buttonId);
    }
}