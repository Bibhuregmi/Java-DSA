package Sorting;

import java.util.Arrays;

public class selectionsort {
    public static void main(String[] args) {
        int arr[] = { 35, -12, 0, 73, -9, 44, 28, -18, 0, 56, 3, -67, 21, 8 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) { // loop starts form the first index
            int lastIndex = arr.length - i - 1; // initializing last index of the array.
            int maxIndex = getMaxIndex(arr, 0, lastIndex);
            swap(arr, maxIndex, lastIndex); // swapping the max value to the last index.
        }
    }

    static int getMaxIndex(int[] arr, int start, int end) { // to find the max element in the array
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }

        }
        return max;
    }

    static void swap(int[] arr, int first, int second) { // basic swap function
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}

/*
 * Selection sort -> Selecting element and putting it in it's right position.
 * Example, in a sorted array, largest
 * element comes to the last index of the array so at first finding the largest
 * element in the array and keeping it
 * in the last index of the array.
 */