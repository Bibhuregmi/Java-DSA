
package Arrays;

import java.util.*;

public class matrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arr[][] = new int[3][3];

        for (int i = 0; i < arr.length; i++) { // taking input for the row of the 2-D array
            for (int j = 0; j < arr[i].length; j++) { // taking input for the colum of the 2-D array
                arr[i][j] = in.nextInt();
            }
        }
        for (int[] a : arr) { // for every element ('a')in an array ('arr') itself is an array ('int[]');
            System.out.println(Arrays.toString(a)); // print the element 'a'.
        }

    }

}
