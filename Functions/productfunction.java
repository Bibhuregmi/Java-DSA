package Functions;

import java.util.*;

public class productfunction {
    public static int product(int a, int b) {
        int prod = a * b;
        return prod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int mul = product(a, b);
        System.out.println("The product of the numbers are: " + mul);
    }

}
