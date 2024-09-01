//https://leetcode.com/problems/two-sum/description/
package Leetcode;

import java.util.Arrays;

public class twoSum {
    // This method ueses nested loop and liner search
    // public static void main(String[] args) {
    // int nums[] = { 2, 7, 11, 15 };
    // int target = 9;
    // int ans[] = twosum(nums, target);
    // System.out.println(Arrays.toString(ans));
    // }

    // static int[] twosum(int[] nums, int target) {
    // for (int i = 0; i < nums.length - 1; i++) {
    // for (int j = i + 1; j < nums.length; j++) {
    // if (nums[i] + nums[j] == target) {
    // return new int[] { i, j };
    // }
    // }
    // }
    // return new int[] {};
    // }

    // Using binary search on given sorted array.

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 4, 9, 56, 90 };
        int target = 8;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            int ans = binSearch(nums, comp, i + 1, nums.length);
            if (ans != -1) {
                return new int[] { i + 1, ans + 1 };
            }
        }
        return new int[] { -1, -1 };

    }

    static int binSearch(int[] nums, int target, int start, int end) {

        start = 0;
        end = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
