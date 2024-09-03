package Maths;

public class prime {

    public static void main(String[] args) {
        int num = 100;
        for (int i = 1; i <= num; i++) {
            System.out.println(i + " " + isPrime(i));
        }
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false; // (0 and 1 are not prime so it returns false.)
        }
        int k = 2; // (starts at 2 smallest prime number)
        while (k * k <= num) { // (will only check till the sq. root of the number)
            if (num % k == 0) { // (if the remainder is 0 -> other factors, it is not prime)
                return false;
            }
            k++; // (increament value of k to check next potential divisor)
        }
        return true; // (if not found then it is prime)
    }

}

/*
 * So the given num this program will print all the the numbers from 1 to 100
 * and also gives if the number is prime or not.
 */
