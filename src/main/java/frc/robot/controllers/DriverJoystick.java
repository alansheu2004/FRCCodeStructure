package frc.robot.controllers;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.util.*;

/**
 * This class is wrapper class to allow the abstraction of buttons and joysticks (removes the need to specify ports every time you get a button)
 */
public class DriverJoystick {
    private Joystick joystick;

    public DriverJoystick() {
        joystick = new Joystick(Context.joystickID);
    }

    public double getThrottle() {
        return getAxisDeadBandManaged(Context.throttleAxisID);
    }

    public double getYaw() {
        return getAxisDeadBandManaged(Context.yawAxisID);
    }

    private double getAxisDeadBandManaged(int axis)
    {
        double aValue = joystick.getRawAxis(axis);

        if(AdditionalMath.isInRange(aValue, -Context.joystickMaxDeadband, Context.joystickMaxDeadband, true)) {
            return 0.0;
        }
        
        return aValue;
    }

    public Joystick getJoystick()
    {
        return joystick;
    }
}
