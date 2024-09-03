package BitManipulation;

public class setbit {

    public static void main(String[] args) {
        int bit = 0b1001000000;
        int n = 7;
        System.out.println(SetBit(bit, n));
        System.out.println(ResetBit(bit, n));
    }

    static String SetBit(int bit, int n) {
        int bitmask = 1 << (n - 1);
        int newBit = (bit | bitmask);
        return Integer.toBinaryString(newBit);
    }

    static String ResetBit(int bit, int n) {
        int bitMask = 1 << (n - 1);
        int newBit = (bit & (~bitMask));
        return Integer.toBinaryString(newBit);
    }
}

/*
 * Same as in this one to set the bit (0->1 and 1->1),
 * I have used the bit mask to do the logical OR operation in the given binary
 * bit.
 * In the logical OR operation we knnow that (0 | 1 -> 1) and ( 1 | 1 -> 1).
 * Similary, to reset the bit meaning (0->0 and 1-0),
 * I have used the bit mask and complemented it to later do & operation with the
 * bit.
 * (1001000000)
 * & (1110111111)
 * (1000000000)
 */