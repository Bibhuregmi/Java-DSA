package Recursion;

public class recur {

    public static void main(String[] args) {
        // Recur(5);
        // System.out.println();
        // RevRecur(5);
        // BothRecur(5);
        int ans = factorial(5);
        System.out.println(ans);
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
}
