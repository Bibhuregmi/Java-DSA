package Recursion;

public class fibonacci {

    public static void main(String[] args) {
        System.out.println(fibo(4));
    }

    public static int fibo(int n) {
        if (n < 2) {
            return n;
        }
        return (fibo(n - 1) + fibo(n - 2));
    }
}

/*
 * This recursive function returns the value of nth number in the fibonacci
 * sequence. We have base case (n<2) ie. (0 and 1) which returns the value
 * according to the recurrence relation.
 * 
 * How to understand and approach problem in recursion?
 * 
 * Identify if the problem can be broken down into smaller problem.
 * Figure out the recurrance relation.
 * Draw the recursive tree.
 * Debug the problem and see flow of function and how they are getting in the
 * stack and how they are returning the value.
 * Identify the number of function calls and focus on the flow of left and right
 * tree calls.
 * 
 */