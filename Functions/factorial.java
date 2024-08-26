package Functions;

import java.util.*;;

public class factorial {

    static void Factorial(int n) {
        if (n <= 0) {
            System.out.println("Invalid");
            return;
        }
        int fact = 1;
        for (int i = n; i >= 1; i--) {
            fact = fact * i;
        }
        System.out.println(fact);
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Factorial(n);
    }
}
