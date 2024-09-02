//Celling of a target number means the smallest number in the array that is greater than or equal to 
// the target. So, in case of the given array, if the target was 15 then it should return index of 25(6),
// becuase 25 is the smallest element in the array that is greater than 15. 

package Array;

public class cellingofatragert {
    public static void main(String[] args) {

        int arr[] = { 2, 5, 6, 7, 9, 10, 25, 26, 46, 67 };
        int target = 70;
        int ans = celling(arr, target);
        System.out.println(ans);

    }

    static int celling(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            if (target > arr[arr.length - 1]) {
                return -1;
            }

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}
