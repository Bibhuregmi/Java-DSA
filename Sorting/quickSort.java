package Sorting;

import java.util.Arrays;

public class quickSort {

    public static void main(String[] args) {
        int arr[] = { 34, 234, 4462, 54, 4, 4345, 34, 32, 242, 433 };
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quicksort(int[] arr, int l, int h) { // two indices low and high is taken in the original array.
        if (l >= h) {
            return; // base condition
        }
        // starting two pointers s and e and low and high of the original array.
        int s = l;
        int e = h;
        int m = s + (e - s) / 2;
        int p = arr[m]; // calculating mid and using the element at the mid as the pivot element
        while (s <= e) {
            while (arr[s] < p) { // moving the start pointer until it finds the element greater or equal than pivot.
                s++;
            }
            while (arr[e] > p) { // moving the end pointer until it finds the element less or equal than pivot.
                e--;
            }
            if (s <= e) { // if the start is less than or equal to end pointer then swapping the value.
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++; // increment start pointer after the swap
                e--; // decreasing end pointer after the swap
            }
        }
        quicksort(arr, l, e); // recursive call for sorting the left part of the pivot element (left<p)
        quicksort(arr, s, h); // recursive call for sorting the right part of the pivot element (p<right)
    }
}

/*
 * Quick sort is an in-place sorting algorithm, meaning it sorts the elements of
 * the array within the same array without needing to create additional arrays
 * or data structures for sorting (except for small stack space due to recursion).
 * 
 * Quick sort is not a stable sorting algorithm, meaning it does not necessarily
 * maintain the relative order of equal elements. For example, if two elements
 * have the same value, their original order in the input array may not be
 * preserved in the sorted array.
 */