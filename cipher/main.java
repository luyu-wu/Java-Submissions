// Wrote some portion of this in my local IDE before seeing that you were gonna check over version history, so there's some missing
import java.util.Scanner;

// PS I took some creative liberties
public class main {
	public static void main (String[] args){
	    Scanner s = new Scanner(System.in);
		Cipher c = new Cipher(0); // Create the object with a shift
		
		
		System.out.println(c.encode("HELLO"));
		c.newShift(1);
        System.out.println(c.encode("ABCDE"));
		c.newShift(-1);
        System.out.println(c.encode("ABCDE"));
		c.newShift(1);
        System.out.println(c.encode("XYZ"));
		c.newShift(7);
        System.out.println(c.encode("ABCDE"));
		c.newShift(-7);
        System.out.println(c.encode("ABCDE"));
		c.newShift(7);
        System.out.println(c.encode("THE END IS NEAR"));
		c.newShift(-4);
        System.out.println(c.encode("ALL ABOARD"));
        
        System.out.println("\n\nInput a String to Decode: ");
        c.decode(s.nextLine());
        
	}
}
