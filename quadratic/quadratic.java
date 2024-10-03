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
	public void standardForm() {
		System.out.println("Standard form:");
		System.out.println(a+"x^2 + "+b+"x + "+c);
	}
	public void vertexForm() {
		System.out.println("Vertex Form:");
		System.out.println("xd no");

	}
	// Change variables
	public void setVars(double newA, double newB, double newC) {
		a = newA;
		b = newB;
		c = newC;
	}
}
