// Question form ChatGPT on Linear Search 
package Arrays;

public class lastoccurance {
    public static void main(String[] args) {

        int nums[] = { 4, 5, 2, 7, 5, 9 };
        int target = 5;
        System.out.println(search(nums, target));
    }

    static int search(int nums[], int target) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
