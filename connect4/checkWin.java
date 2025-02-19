public class checkWin {

    public static int check(int[][] board) {
        // horizontal one
        for (int yp = 0; yp < 6; yp++) {
            for (int xp = 0; xp < 4; xp++) {
                if (
                    board[yp][xp] != 0 &&
                    board[yp][xp] == board[yp][xp + 1] &&
                    board[yp][xp] == board[yp][xp + 2] &&
                    board[yp][xp] == board[yp][xp + 3]
                ) {
                    return board[yp][xp];
                }
            }
        }

        // vertical
        for (int yp = 0; yp < 3; yp++) {
            for (int xp = 0; xp < 7; xp++) {
                if (
                    board[yp][xp] != 0 &&
                    board[yp][xp] == board[yp + 1][xp] &&
                    board[yp][xp] == board[yp + 2][xp] &&
                    board[yp][xp] == board[yp + 3][xp]
                ) {
                    return board[yp][xp];
                }
            }
        }

        // diagonal (downright)
        for (int yp = 0; yp < 3; yp++) {
            for (int xp = 0; xp < 4; xp++) {
                if (
                    board[yp][xp] != 0 &&
                    board[yp][xp] == board[yp + 1][xp + 1] &&
                    board[yp][xp] == board[yp + 2][xp + 2] &&
                    board[yp][xp] == board[yp + 3][xp + 3]
                ) {
                    return board[yp][xp];
                }
            }
        }

        // diagonal (downleft)
        for (int yp = 0; yp < 3; yp++) {
            for (int xp = 3; xp < 7; xp++) {
                if (
                    board[yp][xp] != 0 &&
                    board[yp][xp] == board[yp + 1][xp - 1] &&
                    board[yp][xp] == board[yp + 2][xp - 2] &&
                    board[yp][xp] == board[yp + 3][xp - 3]
                ) {
                    return board[yp][xp];
                }
            }
        }
        return 0;
    }
}
