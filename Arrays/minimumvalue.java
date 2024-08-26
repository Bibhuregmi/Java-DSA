package Arrays;

public class minimumvalue {
    public static void main(String[] args) {

        int arr[] = { 3, 45, 2, 65, 34, 343, -34, 23, 54, 24, 37, 7, 6, 345 };
        System.out.println(min(arr, 1, 5));
    }

    static int min(int arr[], int start, int end) {
        int minVal = arr[0];
        for (int i = start; i <= end; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }
        return minVal;
    }
}
