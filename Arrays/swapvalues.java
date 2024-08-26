package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class swapvalues {
    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        swap(arr, 1, 4);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int arr[], int ind1, int ind3) {
        int temp = arr[ind1];
        arr[ind1] = arr[ind3];
        arr[ind3] = temp;
    }
}
