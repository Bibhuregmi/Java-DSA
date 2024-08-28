package Sorting;

import java.util.Arrays;

public class cyclicsort {
    public static void main(String[] args) {
        int arr[] = { 3, 5, 2, 1, 4 };
        cycilcSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cycilcSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIdx = arr[i] - 1;

            if (arr[i] != arr[correctIdx]) {
                swap(arr, i, correctIdx);
            } else {
                i++;
            }
        }

    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

/*
 * In cyclic sort the element is sorted on their respective index.
 * Cyclic Sort is specifically designed to work with arrays where the elements
 * are within a specific range, usually from 1 to N,
 * where N is the size of the array. This algorithm works by placing each
 * element at its correct position in the array by swapping them
 * until all elements are in their correct positions.
 */