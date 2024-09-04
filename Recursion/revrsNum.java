package Recursion;

public class revrsNum {

    public static void main(String[] args) {
        reverseNum(23442);
        System.out.println(sum);
    }

    static int sum = 0;

    static void reverseNum(int n) {
        if (n == 0) {
            return;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        reverseNum(n / 10);
    }
}