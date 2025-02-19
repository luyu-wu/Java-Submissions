import java.lang.Math;

public class Orbit {
    private double semimajor;
    private double semiminor;

	
	public Orbit (double sMa, double sMi) {
		semimajor = sMa;
		semiminor = sMi;

	}

	public double findY(double x) {
		return Math.sqrt( Math.pow(semiminor,2) * ( 1 - Math.pow(x/semimajor,2) ) ); 
	}

}
