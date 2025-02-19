import java.lang.Math;

public class Quadratic {
    private double x;
    private double y;
    
    private double a;
    private double b;
    private double c;
    
    
    double work;
    
    public Quadratic(double new_a, double new_b, double new_c) {
        a = new_a;
        b = new_b;
        c = new_c;
    }
    

    public void setPoint(double new_x) {
        x = new_x;
        y = (Math.pow(x,2)*a) + (x*b) + c ;
    }
    public double Distance(double x2, double y2) {
        return Math.sqrt(Math.pow(x-x2,2)+Math.pow(y-y2,2));
    }
}
