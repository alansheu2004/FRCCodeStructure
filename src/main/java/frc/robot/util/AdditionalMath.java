package frc.robot.util;

public final class AdditionalMath {
    public static double clamp(double value, double min, double max)
    {
        return Math.max(Math.min(value, max), min);
    }

    public static double handleDeadband (double value, double deadband)
    {
        return Math.abs(value)<deadband ? 0 : value;
    }

    public static long handle (long value, long deadband)
    {
        return Math.abs(value)<deadband ? 0 : value;
    }

    public static boolean isInRange(double value, double min, double max, boolean inclusive)
    {
        return inclusive ? value <= max && value >= min : value < max && value > min;
    }

    public static double OvercomeFriction(double value, double decouple)
    {
        if(value>0) return value+decouple;
        if(value<0) return value-decouple;
        return value;
    }
}
