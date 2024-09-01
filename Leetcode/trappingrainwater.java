package Leetcode;

// https://leetcode.com/problems/trapping-rain-water/description/

public class trappingrainwater {

    public static void main(String[] args) {
        int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }

    static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int MaxLeft = height[left];
        int MaxRight = height[right];
        int result = 0;

        while (left < right) {
            if (MaxLeft < MaxRight) {
                left++;
                MaxLeft = Math.max(MaxLeft, height[left]);
                result += MaxLeft - height[left];
            } else {
                right--;
                MaxRight = Math.max(MaxRight, height[right]);
                result += MaxRight - height[right];
            }
        }
        return result;
    }
}

/*
 * This solution uses the two-pointer approach to calculate the amount of
 * trapped rainwater.
 *
 * 1. Two pointers `left` and `right` are initialized at the start and end of
 * the array, respectively.
 * 2. Two variables `MaxLeft` and `MaxRight` are used to track the maximum
 * height encountered so far from the left and right sides of the array.
 * Initially, they are set to the height(element of the array) at their
 * respective pointers.
 * 3. The idea is to move the pointers inward, comparing the heights:
 * - If `MaxLeft` is less than `MaxRight`, move the left pointer to the right
 * (i.e., `left++`).
 * - Update `MaxLeft` to be the maximum of itself and the current
 * height(element) at the
 * left pointer.
 * - Add the difference between `MaxLeft` and the current height to the
 * `result`. This difference is the trapped water at the current position
 * because the trapped water level is
 * determined by the minimum of the left and right maximum heights up to that
 * point.
 * 4. Similarly, if `MaxLeft` is not less than `MaxRight`, move the right
 * pointer to the left (i.e., `right--`).
 * - Update `MaxRight` to be the maximum of itself and the current height at the
 * right pointer.
 * - Add the difference between `MaxRight` and the current height to the
 * `result`.
 * 5. This approach works because the water level at any index depends on the
 * smaller of the two heights
 * (`MaxLeft` or `MaxRight`), and by moving inward from both sides, you ensure
 * that every height difference
 * is accounted for correctly.
 * 6. The loop continues until the left and right pointers meet, covering all
 * positions in the array.
 * 
 * This algorithm is efficient with a time complexity of O(n) because each
 * element is processed at most once.
 */
