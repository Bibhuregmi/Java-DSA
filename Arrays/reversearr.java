package Arrays;

import java.util.Arrays;

public class reversearr {
    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        reverse(arr, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void reverse(int arr[], int start, int end) {
        start = 0;
        end = arr.length - 1;

        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;

        }

    }

    static void swap(int arr[], int idx1, int idx2) {

        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;

    }

}
