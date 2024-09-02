package BitManipulation;

public class isodd {

    public static void main(String[] args) {
        int n = 65;
        System.out.println(IsOdd(n));
    }

    private static boolean IsOdd(int n) {

        return (n & 1) == 1;
    }
}

/*
 * In the context of evey programming language and computer every numbers is
 * calculated in binary form internally. Binary number consist of only 0 and 1.
 * And there are many operators that can be used to manipulate the bits and
 * "AND (&)" is on of it.
 * Here the given n is first evaluated to binary. (65) -> (1000001).
 * Then, 1000001 & 0000001 == 1 (1 & 1 == 1) so it is odd number.
 * If n = 24, let's convert it to binary (24) -> (11000).
 * Then, 11000 & 00001 != 1 ( 0 & 1 == 0) so it returns false. Hence, 24 is even
 * not odd.
 * Hence if (n & 1 == 1) then the number is odd else even.
 * 
 * In simple term, if Least Significant Bit (last digit of a binary number) is 1
 * then the number is Odd and if it is 0 then the number is Even.
 */