package BitManipulation;

public class uniqueElement {

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 1, 2, 1, 3, 6, 4 };
        System.out.println(ans(arr));
    }

    static int ans(int[] arr) {
        int unique = 0;
        for (int n : arr) {
            unique ^= n;
        }
        return unique;
    }

}

/*
 * So, to find the unique element in the array that is not repeated we can use
 * XOR (^) operator. In simple term XOR returns 'true' if exactly one condition
 * is true. (true ^ false = true) (true ^ true = false)
 * So, in the terms of 1 and 0 => ( 0 ^ 1 = 1) (1 ^ 1 = 0)
 * 
 * Here, we can see that if we take any number and XOR with 1 it returns its
 * complement.
 * Properties
 * (a ^ 1 = ~a)
 * (a ^ 0 = a Identity property) and
 * ( a ^ a = 0 also known as self-cancellation property)
 * 
 * We can use this concept to find the unique element in an array.
 * When we XOR all the elements in an array where every element except one is
 * repeated an even number of times, the result will be the unique element.
 * 2^3^4^1^2^1^3^6^4 -> 2^2 = 0, 3^3 =0, 4^4=0, 1^1=0 -> 0^0^0^0^6 -> 6.
 */
