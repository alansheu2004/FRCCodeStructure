package frc.robot.util;

class Vector {
    public final double x;
    public final double y;
    public final double z;
    
    public Vector() {
        this(0, 0, 0);
    }
    
    public Vector(double x, double y) {
        this(x, y, 0);
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector add(Vector... vectors) {
        double x = 0;
        double y = 0;
        double z = 0;
        for(Vector vector : vectors) {
            x += vector.x;
            y += vector.y;
            z += vector.z;
        }
        return new Vector(x, y, z);
    }

    public static Vector subtract(Vector vector1, Vector vector2) {
        return new Vector(vector1.x + vector2.x, vector1.y + vector2.y, vector1.z + vector2.z);
    }

    public static Vector scale(Vector vector, double scalar) {
        return new Vector(vector.x * scalar, vector.y * scalar, vector.z * scalar);
    }

    public static Vector reverse(Vector vector) {
        return scale(vector, -1);
    }
}