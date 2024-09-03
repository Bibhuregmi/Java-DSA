package BitManipulation;

public class powoftwo {

    public static void main(String[] args) {

        int n = 64;
        boolean ans = (n & (n - 1)) == 0;
        if (n == 0)
            ans = false; // case if n = 0 returns false.
        System.out.println(ans);
    }
}

/*
 * 8 -> 1000
 * 1000 & (1000 -1) -> 1000 & 0111 -> 0000 == 0
 * 
 * 16 -> 10000
 * 10000 & (10000 -1) -> 10000 & 01111 -> 00000 == 0
 * 
 * There is a pattern in binary that the all the power of 2 has only
 * one setbit '1' and rest of them 0.
 * 
 * 2 -> 10
 * 4 -> 100
 * 8 -> 1000
 * 16 -> 10000 an so on for every power of 2.
 */