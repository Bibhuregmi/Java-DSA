package BitManipulation;

public class digitinbinary {

    public static void main(String[] args) {
        int n = 20; // (decimal number)
        int count = 0; // (initializing count as 0)

        while (n > 0) {
            n = n >> 1; // (right shift every digit )
            count++; // (increase count)
        }
        System.out.println(count);
    }
}
