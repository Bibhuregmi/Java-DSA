package Recursion;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] sudoku = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if(solve(sudoku)){
            display(sudoku);
        }else{
            System.out.println("Cannot Solve!");
        }
        
    }
    //Solves the Sudoku board using recursion and backtracking 
    static boolean solve(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1; 

        boolean emptyLeft = true; 
        for (int i = 0; i < n; i++) { //Checking for the empty space
            for(int j=0; j<n; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break; //Exists once a empty cell is found
                }
            }
            if(emptyLeft == false){
                break; 
            }
        }
        //If no empty space is left, the board is solved
        if(emptyLeft){
            return true;
        }

        for(int number =1; number <=9; number++){ //Placing the number form 1 to 9 in the empty space
            if(isSafe(board, row, col, number)){ 
                board[row][col]= number; //Placing the number if it is safe
                if(solve(board)){ //Recursivly trying to solve the rest of the board
                    return true;
                }else{ 
                    board[row][col] = 0; //backtracking if the number palced is mistake
                }
            }
        }
        return false; //If no valid number can be placed in the board
    }

    //Checking if placing the number is safe
    static boolean isSafe (int [] [] board, int row, int col, int num){

        //Checking in the row for duplicate
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == num){
                return false;
            }
        }
        //Checking in the column for duplicate
        for (int[] nums : board) {
            if(nums[col] == num){
                return false;
            }
        }
        //Ckecing in the 3X3 grid for duplicate 
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

       for(int r = rowStart; r< rowStart+sqrt; r++){
        for(int c = colStart; c< colStart+sqrt; c++){
            if(board[r][c] == num){
                return false; 
            }
        }
       }
        return true; //If no duplicate is found the number is in the safe place
    }
    //Displaying the board
    static void display(int [][] board){
        for(int [] row: board){
            for (int num: row){
                System.out.print(num+ " ");
            }
            System.out.println();
        }
    }
}