package Leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
public class allmissingnumber {
    public static void main(String[] args) {

        int nums[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                ans.add(j + 1);
            }
        }
        return ans;
    }

    public static void swap(int[] nums, int f, int s) {
        int temp = nums[f];
        nums[f] = nums[s];
        nums[s] = temp;
    }
}
