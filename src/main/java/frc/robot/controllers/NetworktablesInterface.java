package frc.robot.controllers;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;



public class NetworktablesInterface {

    public double tx; 
    public double ty;
    public double distance;

    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("limelight");
    NetworkTableEntry xEntry = table.getEntry("tx");
    NetworkTableEntry yEntry = table.getEntry("tx");
    NetworkTableEntry robotHeartbeat = table.getEntry("robotHeartbeat");
    // TODO: Find way to get limelight hearbeat to confirm connection

    public NetworktablesInterface(){
        inst.startClientTeam(972);
        inst.startDSClient();  // recommended if running on DS computer; this gets the robot IP from the DS
    }

    public void run(){
        tx = xEntry.getDouble(0.0);
        ty = yEntry.getDouble(0.0);
        robotHeartbeat.setNumber(System.currentTimeMillis());
        System.out.println("tx: " + tx + " ty: " + ty);
    }
}