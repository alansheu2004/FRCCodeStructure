package frc.robot.controllers;

import edu.wpi.first.wpilibj.Compressor;
import frc.robot.util.Context;

public class RobotController {
    public TalonFXDrivetrain drivetrain;
    public AutoDrive autoDrive;
    public NavX navX;
    public NetworktablesInterface ntInterface;
    public DriverJoystick driverJoystick;
    public VisionAllignment visionAllignment;
    public Compressor compressor;
    public Intake intake;
    public OpticalLocalization opticalLocalization;

    public RobotController () {
        /* Change this line when using a different drive train. Don't forget to change the motor ids in context */
        drivetrain = new TalonFXDrivetrain();
        autoDrive = new AutoDrive();
        navX = new NavX();
        ntInterface = new NetworktablesInterface();
        driverJoystick = new DriverJoystick();
        visionAllignment = new VisionAllignment();
        compressor = new Compressor();
        compressor.setClosedLoopControl(true);
        intake = new Intake();
        opticalLocalization = new OpticalLocalization();

        Context.robotController = this;
    }

    public void initAll() {
    }

    public void loopAll() {
        ntInterface.run();
        opticalLocalization.Update();
        visionAllignment.loop();
    }
}