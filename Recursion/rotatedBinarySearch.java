package Recursion;

public class rotatedBinarySearch {

    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 8, 9, 1, 2, 3 };
        System.out.println(RBS(arr, 2, 0, arr.length - 1));
    }

    static int RBS(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (arr[s] <= arr[m]) { // Checking if the left half is sorted.
            if (target >= arr[s] && target <= arr[m]) { // If the target is in the left half this case will handle it
                return RBS(arr, target, s, m - 1);
            } else {
                return RBS(arr, target, m + 1, e); // Else checks in the right half
            }
        }
        if (target >= arr[m] && target <= arr[e]) { // If the left is not sorted then the right one must be sorted
            return RBS(arr, target, m + 1, e); // If target is in the sorted right half
        } else {
            return RBS(arr, target, s, m - 1); // Else target is in the sorted left half.
        }
    }
}
