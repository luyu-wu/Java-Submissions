// written by luyu, code on github written in ide moved to codehs

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Connect4 game = new Connect4();

        System.out.println("Start new game? (Y/N)");
        String input = s1.next();
        if (input.equals("Y")) {
            System.out.println("Starting new game...");
            game.play();
        } else {
            System.out.println("Exiting...");
        }
    }
}
