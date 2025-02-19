import java.util.Scanner;
import java.util.Arrays;

public class main {
	public static void main(String[] args) {
		double[] max_temps = new double[4];
		
		for (int week = 1; week < 5; week++) {
			System.out.println("Week "+week);
			String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

			Scanner scan = new Scanner(System.in);
			double [] temps = new double[7];

			for (int i = 0; i < weekdays.length; i++){
				System.out.println("Enter the temperature for "+weekdays[i]+": ");
				temps[i] = scan.nextDouble();
			}
			double max = 0;
			for (double j:temps) {
				if (j > max) {
					max = j;
				}
			}
			System.out.println("Maximum temperature for Week "+week+": "+max+"\n");
			max_temps[week-1] = max;
		}

		System.out.print("\n\nMaximum temperatures recorded for each week: "+Arrays.toString(max_temps));
	}
}
