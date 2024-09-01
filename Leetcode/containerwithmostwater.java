package Leetcode;

//https://leetcode.com/problems/container-with-most-water/description/ 
public class containerwithmostwater {

    public static void main(String[] args) {
        int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));

    }

    static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int b = right - left;
            int curArea = h * b;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            if (curArea > maxArea) {
                maxArea = curArea;
            }
        }
        return maxArea;
    }
}

/*
 * This is the array question which can be solved using the two pointer
 * approach. Left pointer starts form 0 index and right from the the end of the
 * array and I have initialized the 'h' to be minimum of the two elements of the
 * array and 'b' is the distance of the right and left pointer. MaxArea is
 * initialized as 0 at first and later will be compared with the curArea. I will
 * only move the pointer if one of the element of the pointer is less than the
 * another one.
 */