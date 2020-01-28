package frc.robot.controllers;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import java.sql.Time;

import frc.robot.util.AdditionalMath;
import frc.robot.util.Context;
import frc.robot.util.PID;
public class VisionDistance
{
    double targetHeight = 2.1336; //7 feet in meters
    double camHeight = 0.08;
    double camAngle = 15; //placeholder number
    double limeAngle = 0;
    double estDistance = 0;

    public void loop()
    {
        limeAngle = Context.robotController.ntInterface.ty+20.5; //+20.5 due to centered nature of y angle
        estDistance = (targetHeight-camHeight)/(Math.tan(camAngle+limeAngle));
        System.out.println("LLAngle: "+limeAngle+" distance: "+estDistance);
    }
}