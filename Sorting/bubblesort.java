package Sorting;

import java.util.Arrays;

public class bubblesort {
    public static void main(String[] args) {
        int arr[] = { 35, -12, 0, 73, -9, 44, 28, -18, 0, 56, 3, -67, 21, 8 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        boolean sorted = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {

                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    sorted = true;
                }
            }
            if (!sorted) { // sorted = true; loop ends meaning no more comparison.
                break;
            }
        }
    }
}

/*
 * Bubble sort -> Comparison sort method also known as Syncing sort and Exchange
 * sort.
 * On each iteration, the largest value comes to the last index.
 * No comparison required once the array is sorted.
 */