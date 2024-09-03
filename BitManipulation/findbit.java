package BitManipulation;

public class findbit {

    public static void main(String[] args) {
        int n = 5;
        int bit = 0b10110110;
        System.out.println(findBit(bit, n));
    }

    static int findBit(int bit, int n) {
        int bitmask = 1 << (n - 1);
        return (bit & bitmask) >> n - 1;
    }
}

/*
 * To find the ith bit of the binary number, at first i have created the bit
 * mask at that position using left shift operator.
 * bitmask = 1 << (n-1) -> 1 << (5-1) -> 1 << 4 -> 10000 -> 00010000
 * (10110110)
 * &(00010000)
 * (00010000) and the bit is brought to the Least Significant bit position with
 * the help of right shift.
 * 
 * 00010000 >> 4 -> 0001 -> 1.
 */
