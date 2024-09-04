package Recursion;

public class digitsum {

    public static void main(String[] args) {
        int sum = digitsum(458485);
        int prod = digitprod(458485);
        System.out.println("This sum of digit is " + sum + " " + "&" + " " + "the product is " + prod);
    }

    static int digitsum(int n) {
        if (n == 0) {
            return 0;
        }
        int rem = n % 10; // Taking the remainder of 10 gives the last digit of the number
        return rem + digitsum(n / 10); // Adding the last digit to the value of the other remaining digit.
    }

    static int digitprod(int n) {
        if (n % 10 == n) { // Upadte the base case, if the last digit is remaining it will return it.
            return n;
        }
        int rem = n % 10;
        return rem * digitprod(n / 10);
    }

}
