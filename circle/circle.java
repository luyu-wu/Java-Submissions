import java.lang.Math;

public class circle {
	private double r;
	
	private final double pi = 3.1415;

	public circle(double newRad) {
		r = newRad;
	}
	public double calcDiameter() {
		return 2*r;
	}
	public double calcCircumference() {
		return calcDiameter()*pi;
	}
}
