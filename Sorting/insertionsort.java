package Sorting;

import java.util.Arrays;

public class insertionsort {
    public static void main(String[] args) {
        int arr[] = { 35, -12, 0, 73, -9, 44, 28, -18, 0, 56, 3, -67, 21, 8 };
        InsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void InsertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // starting i from 0 and goes till the second last index of the
                                                   // array.
            for (int j = i + 1; j > 0; j--) {// starts from i+1 and goes back to every other element and compare
                if (arr[j] < arr[j - 1]) { // condition to swap
                    swap(arr, j, j - 1);
                } else {
                    break; // else not then break the loop and check another element of i.
                }
            }
        }
    }

    // basic swap function
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}

/*
 * Insertion sort -> Partially sorting array. For every index, put that index
 * element at the correct index in left
 * hand side.
 */