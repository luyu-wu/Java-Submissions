//import quadratic.java;
import java.util.Scanner;

public class circleApp {
	public static void main(String[] args){
   		Scanner s1 = new Scanner(System.in);
   		System.out.println("Radius: ");
   		double rad = s1.nextDouble();

   		circle c1 = new circle(rad);

   		System.out.println(c1.calcCircumference());
   		
   }
}
