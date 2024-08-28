package Leetcode;

// https://leetcode.com/problems/missing-number/submissions/1370714762/
public class missingNumber {
    public static void main(String[] args) {
        int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println(missingnumber(nums));

    }

    static int missingnumber(int[] nums) {
        int i = 0; // initializing from i
        int n = nums.length;
        while (i < n) {
            int correctIndex = nums[i]; // correct index of the missing element
            if (nums[i] < n && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex); // first sort the array
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        return n;

    }

    static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;

    }

}

/*
 * Using cycle sort to first sort the array and later comparing every sorted
 * element with the index
 * if not found the correct element in correct index, return the missing element
 * else the length of the
 * array.
 */