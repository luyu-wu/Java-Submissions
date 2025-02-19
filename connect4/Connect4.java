import java.util.Scanner;

public class Connect4 {

    public void print(String s1) { // save esomee characters of code ..
        System.out.println(s1);
    }

    public void printBoard(int[][] board) {
        for (int[] i : board) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            print("");
        }
        print("1 2 3 4 5 6 7\n");
    }

    public void play() {
        int board[][] = new int[6][7]; // y-x coordinates cause its easier this way
        int turn = 2;
        Scanner scan = new Scanner(System.in);

        while (checkWin.check(board) == 0) {
            printBoard(board);
            turn %= 2;
            turn += 1;

            print("Player " + turn + "'s turn");
            print("Enter column number (1-7): ");
            int column = scan.nextInt() - 1;

            for (int i = 0; i < 6; i++) {
                if (board[5 - i][column] == 0) {
                    board[5 - i][column] = turn;
                    break;
                }
            }
        }

        print("Player " + turn + " wins!");
    }
}
