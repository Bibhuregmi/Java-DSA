package BitManipulation;

public class power {

    public static void main(String[] args) {
        int base = 4;
        int power = 5;
        int ans = 1;
        while (power > 0) {
            if ((power & 1) == 1) {
                ans *= base;
            }
            base *= base;
            power = power >> 1;
        }
        System.out.println(ans);
    }
}

/*
 * power = 5 (101)
 * (101 & 001) -> (001) == 1 -> ans = ans * base -> (ans = 4) -> base = base *
 * base (base = 16) -> power = 10
 * (10 & 01) -> (00) != 1 -> base = 256 -> power = 1
 * (1 & 1) -> 1 == 1 -> ans = 4 * 256 = 1024 -> base = 65536, power = 0
 * Loop ends -> returns ans = 1024 (4 to the power 5 = 1024)
 * 
 */