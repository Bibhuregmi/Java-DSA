package Leetcode;

// https://leetcode.com/problems/sqrtx/description/
public class sqrt {
    public static void main(String[] args) {

        int x = 7;

        int left = 1;
        int right = x;

        int mid = 0;

        while (left <= right) {
            mid = (right - left) / 2 + left;

            if (x / mid == mid) { // Check if mid is the perfect square root
                System.out.println("working");
                System.out.println(mid);
                return;
            }

            if (mid * mid > x) { // If mid squared is greater than x, reduce the right boundary
                right = mid - 1; // Update right to mid - 1 instead of mid
            } else { // If mid squared is less than x, increase the left boundary
                left = mid + 1; // Update left to mid + 1 instead of mid
            }
        }

        // Print the closest integer square root (which would be the updated `right`)
        System.out.println(right);
    }
}
