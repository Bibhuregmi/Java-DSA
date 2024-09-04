package Maths;

public class Sqrt {

    public static void main(String[] args) {
        int n = 50; // The number to find the sqrt
        int p = 3; // percision value of decimal

        System.out.println(sqrt(n, p));
    }

    // Normal Binary Search
    static double sqrt(int n, int p) {
        int s = 0;
        int e = n;
        double root = 0.0; // Initializing root value
        while (s <= e) {
            int m = s + (e - s) / 2;

            if (m * m == n) {
                return m; // Returning if perfect square is found
            }
            if (m * m > n) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        double increament = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root < n) {
                root += increament; // (increasing the root till the square exceeds n)
            }
            root -= increament; // (going back to the previous smallest value)
            increament /= 10; // (dividing by 10 so it changes and accounts for different place value in each
                              // iteration.)
        }
        return root;

    }

}

/*
 * - Uses Binary Search to find the integer part of the sqrt.
 * - After, it incrementally finds the decimal part upto p decimal places by
 * adjusting value in steps of 0.1, 0.01, 0.001.
 */