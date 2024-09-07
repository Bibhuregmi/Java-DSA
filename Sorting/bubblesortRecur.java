package Sorting;

import java.util.Arrays;

public class bubblesortRecur {

    public static void main(String[] args) {
        int arr[] = { 4, 3, 2, 1 };
        bubble(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr, int i, int j) {
        if (i == 0) {
            return;
        }
        if (j < i) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            bubble(arr, i, j + 1);
        } else {
            bubble(arr, i - 1, 0);
        }
    }
}
/*
 * In bubble sort we know that in each iteration, largest element comes to the
 * last index.
 * 'i' is for controlling the number of passes through the array, reducing each time 
 * because the largest element is already in the correct position at the end. 
 * 'j' is for iterating through the unsorted part of the array and swapping 
 * elements into their correct place.
 */
