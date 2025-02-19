import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number: ");

		for (int i = 5; i<= 100; i++) {
			long n = i;
			int ops = 0;
			
			while (n != 1) {
				if (n%2 == 0){
					n /= 2;
				} else {
					n = n*3 + 1;
				}
				ops ++;
			}
		
			System.out.println(i + " | " + ops);
		}
		

	}
	
}
