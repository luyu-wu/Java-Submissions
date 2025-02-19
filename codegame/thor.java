import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTx = in.nextInt(); // Thor's starting X position
        int initialTy = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            int dist_x = lightX-initialTx;
            int dist_y = lightY-initialTy;
            
            while (dist_x != 0 && dist_y != 0) {
                if (dist_x > 0 && dist_y > 0) {
                    System.out.println("SE");
                    dist_x -= 1;
                    dist_y -= 1;

                } else if (dist_x < 0 && dist_y > 0) {
                    System.out.println("SW");
                    dist_x += 1;
                    dist_y -= 1;

                } else if (dist_x > 0 && dist_y < 0) {
                    System.out.println("NE");
                    dist_x -= 1;
                    dist_y += 1;

                } else if (dist_x < 0 && dist_y < 0) {
                    System.out.println("NW");
                    dist_x += 1;
                    dist_y += 1;

                }
            }
            
            if (dist_x < 0) {
                for (int i=0; (i > dist_x ); i--) {
                    System.out.println("W");
                }
            } else if (dist_x > 0) {
                for (int i=0; (i < dist_x ); i++ ) {
                    System.out.println("E");
                }  
            }

            if (dist_y < 0) {
                for (int i=0; (i > dist_y ); i--) {
                    System.out.println("N");
                }
            } else if (dist_y > 0) {
                for (int i=0; (i < dist_y); i++ ) {
                    System.out.println("S");
                }  
            }
        }
    }
}
