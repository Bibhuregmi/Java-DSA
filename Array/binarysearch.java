package Array;

public class binarysearch {
    public static void main(String[] args) {
        int arr[] = { 90, 78, 66, 55, 44, 33, 25, 19, 12, 8, 4, 1 };

        System.out.println(binsearch(arr, 66));

    }

    static int binsearch(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (target > arr[mid]) {
                    start = mid + 1;

                } else {
                    end = mid - 1;
                }
            } else {
                if (target < arr[mid]) {
                    start = mid + 1;

                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}
