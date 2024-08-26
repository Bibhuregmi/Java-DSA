package Arrays;

import java.util.Arrays;

public class matrixbinarysearch {

    public static void main(String[] args) {
        int arr[][] = {
                { 1, 3, 5, 7 },
                { 2, 4, 6, 8 },
                { 9, 11, 13, 15 },
                { 10, 12, 14, 16 }
        };
        int target = 15;

        int ans[] = matrixsearch(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] matrixsearch(int[][] arr, int target) {

        int row = 0;
        int col = arr.length - 1;

        while (row < arr.length && col >= 0) {
            if (arr[row][col] == target) {
                // System.out.println("The target is found at row: " + (row + 1) + " " +
                // "column: " + (col + 1));
                return new int[] { row + 1, col + 1 };
                // returns value in the one index format same as for matrix.
            }
            if (arr[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return new int[] { -1, -1 };
    }
}

// this is not a method of the binary search in the matrix because the arrays
// are not strictly sorted
// this method only ensure the search space is reduced so that we dont have to
// use the nested for loop.