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
        if (r < arr.length -1 ){  //Condtion to move down the row
            obstacles(e + "D", arr, r+1, c);
        }
        if(c < arr[0].length-1){ //Condition to move right the column
            obstacles(e + "R", arr, r, c+1);
        }
        if(r < arr.length -1 && c < arr[0].length-1 ){ //Condition to move down diagoanlly 
            obstacles(e + "di", arr, r+1, c+1);
        }
    }
}