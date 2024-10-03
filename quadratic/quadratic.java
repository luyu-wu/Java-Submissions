import java.lang.Math;

public class quadratic {
	private double a;
	private double b;
	private double c;

	public quadratic(double newA, double newB, double newC) {
		a = newA;
		b = newB;
		c = newC;
	}
	public void solveQuad() {
		System.out.println( (-b + Math.sqrt( Math.pow(b,2) - (4*a*c)))/2*a);
	}

	// Change variables
	public void setVars(double newA, double newB, double newC) {
		a = newA;
		b = newB;
		c = newC;
	}
}
