package Leetcode;

public class NQueens {
    public static void main(String[] args) {
        int n = 4; 
        boolean [] [] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }

    static int queens (boolean[] [] board, int row){
        if (row == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count  = 0 ;
        //place the queen and check for the every row and column
        for (int column = 0; column<board.length; column++){
            if (isSafe(board,row,column)){
                board[row][column] = true; //Placing the queen the board and marking it true
                count += queens(board, row+1); //Once queen is place checking to place another queen on the next row
                board[row][column] = false; //backtracking and changing the value to false if the later condition fails
            }
        }
        return count;
    }
    static boolean isSafe(boolean board[][], int row, int column){
        //checking for row
       for(int i=0; i< row;i++){
        if (board[i][column]){
            return false;
        }
       }

       //checking for the diagonal left
       int maxLeft = Math.min(row,column);
       for(int i=1; i<= maxLeft; i++){
        if(board[row-i][column-i]){
            return false;
        }
       }

       //checking for the diagonal right 
       int maxRight = Math.min(row,board.length - column -1);
       for(int i=1; i<= maxRight; i++){
        if (board[row-i][column+i]){
            return false;
        }
       }
       return true;
    }

    static void display(boolean[][] board) { //printing the board
       for (boolean [] row : board){
            for(boolean element : row){
                if(element){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
       }
    }
}