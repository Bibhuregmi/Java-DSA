
package Recursion;

public class searchArray {

    public static void main(String[] args) {
        int arr[] = { 4, 5, 2, 5, 1, 34, 54, 23, 5, 63, 34 };
        System.out.println(Search(arr, 1, 0));

    }

    static int Search(int[] arr, int target, int indx) {
        if (indx == arr.length) {
            return -1;
        }
        if (arr[indx] == target) {
            return indx;
        }
        return Search(arr, target, indx + 1);
    }
}
// Recursive way to find the target in an array (Linear Search)