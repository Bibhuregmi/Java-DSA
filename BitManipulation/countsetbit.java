package BitManipulation;

//https://leetcode.com/problems/number-of-1-bits/submissions/1377191881/?envType=problem-list-v2&envId=bit-manipulation
public class countsetbit {

    public static void main(String[] args) {
        int n = 7;
        int count = 0;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(FirstApproach(n, count));
        System.out.println(SecondApproach(n, count));

    }

    static int FirstApproach(int n, int count) {
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    /*
     * In first approach, if the & value == 1, the counter is increased and then the
     * num is right shift by 1.
     */

    static int SecondApproach(int n, int count) {
        while (n > 0) {
            int rem = n % 2;
            n = n / 2;
            if (rem == 1) {
                count++;
            }
        }
        return count;
    }
}

/*
 * Here remainder is taken and constant division is performed and count has only
 * been increased if the value of remainder is 1.
 */
