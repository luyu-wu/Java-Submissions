import java.util.*;

import java.lang.Math;

public class main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a");
		double a = in.nextDouble();

		System.out.println("Enter b");
		double b = in.nextDouble();

		System.out.println("Enter x");
		double x = in.nextDouble();

		System.out.println("Enter y");
		double y = in.nextDouble();


		double slope = -10;
		double delta = 0;
		double prev_dist = 100;
		while (true) {
			double l_a = slope;
			double l_b = y - slope * x;
			double x_inter = (b-l_b)/(l_a-a);
			
			double y_inter = (a*x_inter) + b;

			double distance = Math.sqrt(Math.pow(x_inter-x,2)+Math.pow(y_inter-y,2)); 

			if (distance > prev_dist) {
				break;
			} else {
				prev_dist = distance;
			}
			slope += 0.1;
		}

		System.out.println("The shortest distance is " + prev_dist);
	}
}
