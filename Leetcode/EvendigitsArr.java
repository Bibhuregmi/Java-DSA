//Question Link:https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/

package Leetcode;

public class EvendigitsArr {
    public static void main(String[] args) {
        int nums[] = { 12, 345, 2, 6, 7896 };
        System.out.println(findNumbers(nums));

    }

    static int findNumbers(int nums[]) {
        int count = 0;
        for (int num : nums) {
            if (even(num)) {
                count++;
            }
        }

        return count;
    }

    static boolean even(int num) {
        int numofDigit = digits(num);
        if (numofDigit % 2 == 0) {
            return true;
        }
        return false;
    }

    static int digits(int n) {
        // int count = 0;
        // while (n > 0) {
        // count++;
        // n = n / 10;
        // }
        // return count;
        return (int) (Math.log10(n) + 1);
    }
}
