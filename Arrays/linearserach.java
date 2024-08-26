package Arrays;

public class linearserach {
    public static void main(String[] args) {
        int nums[] = { 12, 34, 23, 24, 54, 3, 36, 43 };
        int target = 3;
        int ans = linersearch(nums, target);
        System.out.println("Element is found at the index: " + ans);
    }

    static int linersearch(int arr[], int target) {
        for (int i = 0; i <= arr.length - 1; i++) {
            int ele = arr[i];
            if (ele == target) {
                return i;
            }
        }
        return -1; // returns if the element is not found
    }
}
