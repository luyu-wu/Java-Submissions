import java.util.Scanner;

public class main{
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);

		String line = scan.nextLine();
		String empty = "";
		for (int i = 0; i < line.length(); i++) {
			empty += line.charAt(line.length()-i - 1 );
		}
		System.out.println(empty);
	}
}
