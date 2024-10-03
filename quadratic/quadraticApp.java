//import quadratic.java;
import java.util.Scanner;

public class quadraticApp {
	public static void main(String[] args){
   		Scanner s1 = new Scanner(System.in);
   		System.out.println("Input A: ");
   		double a = s1.nextDouble();
		System.out.println("Input B: ");
   		double b = s1.nextDouble();
   		System.out.println("Input C: ");
   		double c = s1.nextDouble();

   		quadratic q1 = new quadratic(a,b,c);
   		q1.solveQuad();
   		
   }
}
