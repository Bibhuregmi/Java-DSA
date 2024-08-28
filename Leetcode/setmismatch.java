package Leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/set-mismatch/
public class setmismatch {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 2 };
        int ans[] = findErrorNums(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] findErrorNums(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int correctIdx = nums[i] - 1;
            if (nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            } else {
                i++;
            }
        }
        for (int index = 0; index < n; index++) {
            if (nums[index] != index + 1) {
                return new int[] { nums[index], index + 1 };
            }
        }
        return new int[] { -1, -1 };
    }

    static void swap(int[] nums, int f, int s) {
        int temp = nums[f];
        nums[f] = nums[s];
        nums[s] = temp;
    }
}
