package Recursion;

public class countZero {

    public static void main(String[] args) {
        System.out.println(count(29403402));
    }

    static int count(int n) {
        return helper(n, 0); // (taking the helper function which takes number and the count in its argument)
    }

    static int helper(int n, int c) {
        if (n == 0) {
            return c; // (if the n =0 returns count)
        }

        int rem = n % 10; // (takin remainder of the number )
        if (rem == 0) { // (and if the remainder is 0 means that the digit is 0)
            return helper(n / 10, c + 1); // (calls the function and updates the n by n/10, and count +1)
        }
        return helper(n / 10, c); // (if not check for the another number and count remains 0)
    }
    /*
     * Here count is passed in the argument beause we can update it only if the
     * remainder is 0 while dividing the number.
     * helper(29403402, 0) -> rem = 2 != 0 ->
     * helper(2940340, 0) -> rem = 0 == 0 -> count +1
     * helper(294034 ,1) -> rem = 4 != 0 ->
     * helper (29403, 1) -> rem = 3 != 0 ->
     * helper (2940, 1) -> rem = 0 == 0 -> count +1
     * helper (294, 2) -> rem = 4!=0 ->
     * helper (29, 2) -> rem 9!= 0 ->
     * helper (2, 2) -> rem 2 != 0 ->
     * helper (0 ,2) -> here n == 0 base case hits and retuns the count which is 2.
     */
}
