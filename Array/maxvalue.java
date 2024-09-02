package Array;

public class maxvalue {
    public static void main(String[] args) {

        int arr[] = { 1, 43, 53, 332, 232, 34, 2, 434, 32, 434, 33 };
        System.out.println(max(arr));
    }

    static int max(int[] arr) {
        int maxval = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxval < arr[i]) {
                maxval = arr[i];
            }

        }
        return maxval;
    }
}
