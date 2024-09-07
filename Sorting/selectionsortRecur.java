package Sorting;

import java.util.Arrays;

public class selectionsortRecur {

    public static void main(String[] args) {
        int arr[] = { 3, 4, 2, 1, 7, 5 };
        selection(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void selection(int[] arr, int i, int j, int max) {
        if (i == 0) {
            return;
        }
        if (j < i) {
            if (arr[j] > arr[max]) {
                selection(arr, i, j + 1, j);
            } else {
                selection(arr, i, j + 1, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[i - 1];
            arr[i - 1] = temp;
            selection(arr, i - 1, 0, 0);
        }
    }
}

/*
 * Here max element is passed upon the arguments so that the each time the
 * function is called, the max element will be updated if new max element is
 * found because in selection sort, max element is swapped with the element in
 * the last index of the array.
 */

/*
 * Which is better Iterative or Recrsive way of Bubble and Selection sort?
 * -> In the context of the recursive way of bubble and selection sort, it is
 * less memory efficient beacause it uses O(n) space due to the use of recursive
 * call stack which is not ideal for the practical and large scale application.
 * Hence, iterative way is more prefered rather than the recursive way.
 */