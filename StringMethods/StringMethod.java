import java.lang.Math;
import java.util.Scanner;

public class StringMethod {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// EXERCISE 1
		System.out.print("Enter your first name: ");
		String first = scan.nextLine();

		System.out.print("Enter your last name: ");
		String last = scan.nextLine();

		System.out.println("Your alphabetical name is: "+last+", "+first);
		System.out.println("Testing if first name is longer than last name: "+ (first.length() > last.length()) );

		// EXERCISE 2
		System.out.print("Ex.2\nWelcome to College of Doctors:\nEnter your name: ");
		String name = scan.nextLine();
		String no_salute = name.substring(name.indexOf(" ") + 1,name.length());
		System.out.print("Your first name is: ");
		System.out.println(no_salute.substring(0,no_salute.indexOf(" ")));

		String no_first = no_salute.substring(no_salute.indexOf(" ")+1,no_salute.length());
		System.out.print("Your last name is: ");
		System.out.println(no_first);
		//System.out.println(no_first.substring(0,no_first.indexOf(" ")));

		System.out.print("Your salutation is: ");
		System.out.print(name.substring(0,name.indexOf(" ")));

		// EXERCISE 3
		System.out.println("\n\nEx.3:\nEnter your two words: ");
		String s1 = scan.nextLine();
		String s2 = scan.nextLine();

		boolean pMatch = s1.matches(s2);
		boolean lMatch = s1.toLowerCase().matches(s2.toLowerCase());

		System.out.println("Strings are exactly the same: "+pMatch);
		System.out.println("Strings are, ignoring their case, the same: "+lMatch);


		// EXERCISE 4
		System.out.print("\n\nEx.4:\nEnter your team name: ");
		String team = scan.nextLine();
		String [] words = team.split(" ");
		System.out.println(words[0].toUpperCase() + " " +  words[1].toLowerCase() + " " + words[2].toLowerCase() + " " + words[3].toUpperCase() );
	}
}
