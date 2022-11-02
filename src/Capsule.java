import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Capsule {

    static final double PI = 3.14159265358979;

    private int radius;
    private double length;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String volume() {
        // DecimalFormat df = new DecimalFormat("#.###");
       // df.setRoundingMode(RoundingMode.HALF_UP);
        return String.format("%.3f",PI * radius * radius * ((((double)4/3) * radius + length)));
    }

    public String surfaceArea() {
        //DecimalFormat df = new DecimalFormat("#.####");
       // df.setRoundingMode(RoundingMode.HALF_UP);
        return String.format("%.4f",(2 * PI * radius * ( (2 * radius) + length) ));
        //return df.format(2 * PI * radius * ( (2 * radius) + length) );
    }

    public String circumference() {
       // DecimalFormat df = new DecimalFormat("#.####");
       // df.setRoundingMode(RoundingMode.HALF_UP);
        return String.format("%.4f",2 * PI * radius);
    }
}
