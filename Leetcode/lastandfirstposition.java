// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
package Leetcode;

public class lastandfirstposition {
    public static void main(String[] args) {
        int nums[] = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int firstOcc = firstelement(nums, target);
        int lastOcc = lastelement(nums, target);
        System.out.println(firstOcc + "," + lastOcc);

    }

    static int firstelement(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        int first = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;

            if (target > arr[m]) {
                s = m + 1;
            } else if (target < arr[m]) {
                e = m - 1;
            } else {
                first = m;
                e = m - 1;
            }
        }
        return first;
    }

    static int lastelement(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        int last = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;

            if (target > arr[m]) {
                s = m + 1;
            } else if (target < arr[m]) {
                e = m - 1;
            } else {
                last = m;
                s = m + 1;
            }
        }
        return last;
    }
}
