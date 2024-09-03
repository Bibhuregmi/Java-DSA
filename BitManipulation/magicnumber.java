// Amazon Question
/*
 * A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5. 
 * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), .......
 */

package BitManipulation;

public class magicnumber {

    public static void main(String[] args) {
        int n = 8; // (100 in binary)
        int base = 5;
        int ans = 0;
        while (n > 0) {
            int rightBit = n & 1; // (This will give the last digit of the binary number)
            n = n >> 1; // (right shift the number by 1 to take the next digit)

            ans += base * rightBit; // (Update ans = ans + base * rightBit )
            base = base * 5; // (Update base by the power of 5 -> 5,25,125,625)
        }
        System.out.println(ans);
    }
}
