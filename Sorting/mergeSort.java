package Sorting;

import java.util.Arrays;

public class mergeSort {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 7, 3, 8, 1, 4 };
        inplaceMergesort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergesort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int m = arr.length / 2;
        int[] left = mergesort(Arrays.copyOfRange(arr, 0, m));
        int[] right = mergesort(Arrays.copyOfRange(arr, m, arr.length));
        return merge(left, right);
    }

    public static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        // if one of the array is not compelete

        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
    /*
     * In this version of the merge sort, every function call creates a new array
     * and returns a sorted version of it. Since a new array is created in each
     * recursive call, the original array is not modified directly; instead, new
     * sorted arrays are returned and merged.
     * 
     * It is also possible to do in place merge sort where value of the indices is
     * passed and compared which allows us to modify the array without creating
     * other array in each function call. Although a new array is needed to store
     * the value of the sorted part after the comparision.
     */

    static void inplaceMergesort(int[] arr, int s, int e) {
        if (e - s == 1) { // base condition meaning only one element to be sorted.
            return;
        }

        int m = s + (e - s) / 2; // dividing into two halves.
        inplaceMergesort(arr, s, m); // sorting one half starting from s to m
        inplaceMergesort(arr, m, e); // sorting another half starting from m to e.

        mergeinPlace(arr, s, m, e); // merging two sorted into the one array.
    }

    static void mergeinPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s]; // new array of length (e-s).
        // taking indices for comparison
        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i]; // value will be added at that index of the the new array.
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++; // index of new array should incerease in each comparison
        }
        // If any of the array is exhaustd(no element in array is left of comparison),
        // it is added to the mix.
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }
        // Mix only holds the sorted array during the merge pase, so this ensures that
        // all the values is passed to the orginal array.
        // This is what makes the merge sort "in place" — it sorts sections of the
        // original array directly rather than creating entirely new arrays at each
        // recursion level.
        for (int a = 0; a < mix.length; a++) {
            arr[s + a] = mix[a];
        }
    }

    /*
     * This version of merge sort sorts the array in place, meaning that it modifies
     * the original array instead of creating and returning a new sorted array.
     * This is achieved by sorting the sub-arrays directly within the existing array
     * and merging them back without needing to create a complete copy of the array
     * at each step, although a temporary array is still used for merging.
     */
}
