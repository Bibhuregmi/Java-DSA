package Projects;

import java.io.InputStream;
import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        char board[][] = new char[3][3]; // created a 3X3 board of the standard tic-tac-toe
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' '; // empty at initial
            }
        }

        char player = 'X'; // player X initialized
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in); // taking input

        while (!gameOver) { // loops runs till the gameOver = true
            printBoard(board); // method to print the 3X3 board
            System.out.println("Player input your play: " + ' ' + player);
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println();

            if (board[row][col] == ' ') {
                board[row][col] = player; // puts the player to the inputed index
                gameOver = win(board, player) || draw(board, player); // game is over if there is a win or there is a
                                                                      // draw.
                if (gameOver) {
                    if (win(board, player)) {
                        System.out.println("Player" + ' ' + player + ' ' + "has won."); // if win it will print
                    } else {
                        System.out.println("Game is draw!"); // else in the case of draw
                    }
                } else { // changing the player
                    if (player == 'X') {
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            } else {
                System.out.println("Invalid move!!");
            }
        }
        printBoard(board);
    }

    public static boolean win(char[][] board, char player) { // conditions to win the game
        for (int row = 0; row < board.length; row++) {
            // condition to win in row
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        for (int col = 0; col < board[0].length; col++) {
            // condition to win in column
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // condition to win in diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean draw(char[][] board, char player) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // method to print the board.
    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
                if (col < board[row].length - 1) {
                    System.out.print("|");
                }
            }

            System.out.println();
        }

    }

}
