package Arrays;

import java.util.Arrays;

public class twodarrsearch {
    public static void main(String[] args) {
        int arr[][] = {
                { 3, 34, 43, 5 },
                { 76, 97, 45 },
                { 3, 45, 65, 343, 63 },
                { 36, 4235, 75, 49, 43, 78 }
        };
        int ans[] = search(arr, 78);
        System.out.println("The target element is found at the index: " + Arrays.toString(ans));
        System.out.println("The max value of the 2-D array is: " + max(arr));
        System.out.println("The minimum value of the 2-D array is: " + min(arr));
    }

    static int[] search(int arr[][], int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    static int max(int arr[][]) {
        int maxV = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > maxV) {
                    maxV = arr[i][j];
                }
            }

        }
        return maxV;
    }

    static int min(int arr[][]) {
        int minV = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < minV) {
                    minV = arr[i][j];
                }
            }
        }
        return minV;
    }
}
