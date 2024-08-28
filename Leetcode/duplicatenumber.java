package Leetcode;

//https://leetcode.com/problems/find-the-duplicate-number/description/
public class duplicatenumber {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 3, 4, 2 };
        System.out.println(duplicate(arr));
    }

    public static int duplicate(int[] arr) {
        int i = 0;
        int n = arr.length;

        while (i < n) {
            int correctIdx = arr[i] - 1;
            if (arr[i] != arr[correctIdx]) {
                swap(arr, i, correctIdx);
            } else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] != j + 1) {
                return arr[j];
            }
        }
        return n;
    }

    public static void swap(int[] arr, int f, int s) {
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
}

/*
 * At first we will sort the array with the help of cyclic sort and then compare
 * each element of the array with its respective index, since the array will be
 * sorted, the element has its index as (index+1) if any element not satisfying
 * this conditon will be for sure a duplicate value.
 */