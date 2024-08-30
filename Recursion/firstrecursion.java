package Recursion;

public class firstrecursion {

    public static void main(String[] args) {
        print(1);
    }

    static void print(int n) {
        if (n == 6)
            return; // base condition where our recursion function will stop making new call to
                    // itself.

        System.out.println(n);
        print(n + 1);
    }
}

/*
 * If a funtion is called again and again each call creates a new stack in the
 * memory. If no base condition is introuduced a stack memory will fill up
 * indefinitely and stack overflow occurs.
 * 
 * Why recursion?
 * It helps in soving a big and complex problem in a simpler way and each
 * recursive solution can be converted to iterations (loops) and vice versa.
 * In the case of recursion, since each function call creates new memory, Space
 * copmlexity is O(n) where n is the number of the function call.
 */