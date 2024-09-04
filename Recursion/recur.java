package Recursion;

public class recur {

    public static void main(String[] args) {
        // Recur(5);
        // System.out.println();
        // RevRecur(5);
        // BothRecur(5);
        // int ans = factorial(5);
        // int sumAns = sum(100);
        // System.out.println(ans);
        // System.out.println(sumAns);
        fun(5);
    }

    static void Recur(int n) {
        if (n == 0) {
            return;
        }
        Recur(n - 1); // The recursive call goes deep till the base case has been hit.
        System.out.println(n); // Prints number from the top of the stack till all the function call have been
                               // removed from stack.
    }

    static void RevRecur(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n); // Current value of n is printed before moving to the recursive call.
        RevRecur(n - 1); // recursive function is called to print the n -1 number.
    }

    // Above recursive program can be written in same block of code.
    static void BothRecur(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        BothRecur(n - 1);
        System.out.println(n);
    }

    // Program to find the factorial of a number.
    // Here int is the return type cause it will be returning a value to the
    // function it was called.
    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1); // it will return the interger value.
    }

    // Sum of the numbers can also be calculated
    static int sum(int n) {
        if (n <= 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    static void fun(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        // fun(n--);
        fun(--n);
    }
    /*
     * Here is the difference between (n--) & (--n).
     * In (n--), the value of n is passed before subtracting it but for (--n),
     * First the value is subtracted and n is passed.
     *
     * This cause the change of the recursive behaviour, in the case of
     * (n--), value is passed before decreasing it so recursion uses orignal value
     * before decreasing the value causing the repeating of the value in output and
     * eventually stackoverflow.
     * But for the (--n), the value is decreased before passing the value and
     * outputs as 5 4 3 2 1.
     */
}
