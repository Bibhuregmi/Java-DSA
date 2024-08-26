package Leetcode;

public class sixtyNine {

    static int[] changeNineAndSix(int[] arr) {

        if (arr[0] == 6) {
            arr[0] = 9;
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == 6) {
                arr[i] = 9;
                return arr;
            }
        }
        return arr;

    }

    public static void main(String[] args) {
        int arr[] = { 9, 9, 9, 6 };

        changeNineAndSix(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
