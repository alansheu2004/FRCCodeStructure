package frc.robot.subsystems;

import frc.robot.RobotManager;
import frc.robot.util.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class ExampleSubsystem extends Subsystem {
    private TalonSRX motor;

    public ExampleSubsystem(RobotManager manager) {
        super(manager);
        motor = new TalonSRX(Constants.EXAMPLE_MOTOR_ID);
    }

    public void doSomething() {
        motor.set(ControlMode.PercentOutput, 1);
    }
}