package Array;

//https://leetcode.com/problems/find-in-mountain-array/description/
public class mountainHard {
    public static void main(String[] args) {

        int arr[] = { 0, 1, 2, 4, 2, 1 };
        int target = 3;

        int peakIdx = findPeakIndex(arr);
        int firstIndex = findFirst(arr, target, peakIdx);
        int lastIndex = findLast(arr, target, peakIdx);
        int minIndex = Math.min(firstIndex, lastIndex);
        System.out.println(minIndex);

    }

    private static int findPeakIndex(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;
        ;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid == 0) {
                return mid + 1;
            }
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return mid;
    }

    private static int findFirst(int[] arr, int target, int peakIdx) {

        int s = 0;
        int e = peakIdx - 1;
        int first = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;

            if (target > arr[m]) {
                s = m + 1;
            } else if (target < arr[m]) {
                e = m - 1;
            } else {
                first = m;
                e = m - 1;
            }
        }
        return first;

    }

    private static int findLast(int[] arr, int target, int peakIdx) {

        int s = peakIdx + 1;
        int e = arr.length - 1;
        int last = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;

            if (target > arr[m]) {
                s = m + 1;
            } else if (target < arr[m]) {
                e = m - 1;
            } else {
                last = m;
                e = m - 1;
            }
        }
        return last;

    }
}

