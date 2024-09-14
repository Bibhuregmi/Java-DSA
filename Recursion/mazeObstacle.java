package Recursion;

public class mazeObstacle {
    public static void main(String[] args) {
        boolean maze [] [] = {
            {true, true, true},
            {true, true, true},
            {true, false, true}
        };
        obstacles(" ", maze, 0, 0);
    }

    static void obstacles(String e, boolean arr[] [], int r, int c){
        if (r == arr.length -1 && c == arr[0].length-1){
            System.out.println(e);
            return; 
        }
        if  (arr[r] [c] == false){ //If it inconuters any obstacle meaning "false" in a boolean matrix, simply it will return. 
            return; 
        }
        arr[r] [c] = false; //Marking every cell to false for the path it has found. 
        if (r < arr.length -1 ){  //Condtion to move down the row
            obstacles(e + "D", arr, r+1, c);
        }
        if(c < arr[0].length-1){ //Condition to move right the column
            obstacles(e + "R", arr, r, c+1);
        }
        if(r < arr.length -1 && c < arr[0].length-1 ){ //Condition to move down diagoanlly 
            obstacles(e + "di", arr, r+1, c+1);
        }
            // Now we are given the choice that we can move into any directions be that L, R, U, D and di. so for that I will introduce two 
            // conditions.
        if( r > 0){
            obstacles(e+ "U", arr, r-1, c);
        } 
        if (c > 0){
            obstacles(e + "L", arr, r, c-1);
        }

        arr [r] [c] = true; //Reverting back so that other path can be found. 

        //  After running this program, it goes to stack overflow because program will keep going to the starting position and base case will never hit. 
        // Here now comes the concept of backtracking. so at first for that I will just mark every cell it has gone to false so that, 
        // no call is made for that function. And at the end of the function, I will revert it back to true so that other path can be found. 
        // So this is the basic concept of the backtracking where an object is modified in the function call and later brought back to its 
        // original condition.
    
    }
}