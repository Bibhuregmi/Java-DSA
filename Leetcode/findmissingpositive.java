package Leetcode;

public class findmissingpositive {
    public static void main(String[] args) {
        int nums[] = { 3, 4, -1, 1 };
        System.out.println(firstMissingPositive(nums));

    }

    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            int correctIdx = nums[i] - 1;
            if (nums[i] > 0 && nums[i] != nums[correctIdx]) { //nums[i] > 0 it ensures no negative value are evaluated which is totally irrelevant in our current case. 
                swap(nums, i, correctIdx);
            } else {
                i++;
            }
        }
        for (int index = 0; index < n; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }
        return n + 1;
    }

    static void swap(int[] nums, int f, int s) {
        int temp = nums[f];
        nums[f] = nums[s];
        nums[s] = temp;
    }
}
