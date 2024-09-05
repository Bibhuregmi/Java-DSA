package Leetcode;

import java.util.Arrays;

public class moveZero {

    public static void main(String[] args) {
        int nums[] = { 0, 1, 0, 3, 12 };
        moveZero(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void moveZero(int[] nums) {
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            if (nums[r] == 0) {
                r++;
            } else {
                swap(nums, l, r);
                l++;
                r++;
            }
        }
    }

    static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
