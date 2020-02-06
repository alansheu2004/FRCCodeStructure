package frc.robot.controllers;
import frc.robot.util.Context;

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