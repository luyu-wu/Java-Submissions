import java.util.Scanner;

public class main {
	public static void main (String[] args){
		// 80-100 A
		// 70-79 B
		// 60-69 C
		Scanner scan = new Scanner(System.in);
		System.out.println("Input a grade: ");
		int grade = scan.nextInt();

		if (grade >= 80) {
			System.out.println("A");
		} else if (grade >= 70) {
			System.out.println("B");
		} else if (grade >= 60) {
			System.out.println("C");
		} else {
			System.out.println("FAILL L BOZO");
		}

		
	}
}
