package Maths;

public class sieve {

    public static void main(String[] args) {
        int n = 40;
        boolean[] primes = new boolean[n + 1]; // (all the elements are initialized to be false and this array will be
                                               // used to mark non-prime numbers)
        sieve(n, primes);
    }

    // here true = not a prime and false = prime number.
    static void sieve(int n, boolean[] primes) {
        for (int i = 2; i * i <= n; i++) { // (starting from 2, prime is calculated)
            if (!primes[i]) { // (if true ie. not a prime we need to eliminate the multiples of 2.)
                for (int j = i * 2; j <= n; j += i) { // (This loop starts at i×2 and goes up to n, incrementing by i. )
                    primes[j] = true; // (not a prime number.)
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                System.out.print(i + " "); // (printing all the primes number from i to n)
            }
        }
    }
}
