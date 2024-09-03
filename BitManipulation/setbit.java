package BitManipulation;

public class setbit {

    public static void main(String[] args) {
        int bit = 0b1000000;
        int n = 6;
        System.out.println(SetBit(bit, n));
    }

    static String SetBit(int bit, int n) {
        int bitmask = 1 << (n - 1);
        int newBit = (bit | bitmask);
        return Integer.toBinaryString(newBit);
    }
}

/*
 * Same as in this one, I have used the bit mask to do the logical OR operation
 * in the given binary bit.
 * In the logical OR operation (0 | 1 -> 1) and ( 1 | 1 -> 1).
 */