package Recursion;

public class countLast {

    public static void main(String[] args) {
        String str = "hello bibhu          ";
        int ans = last(str, str.length() - 1, 0);
        System.out.println(ans);

        // int counter = 0;
        // for (int i = str.length() - 1; i >= 0; i--) {

        // if (str.charAt(i) != ' ') {
        // counter++;

        // if (i == 0) {
        // break;
        // }

        // if (str.charAt(i - 1) == ' ') {
        // break;
        // }
        // }

        // }
        // System.out.println(counter);

    }

    static int last(String str, int idx, int c) {
        if (idx == 0) {
            return c + 1; // (if no space is found in between)
        }

        if (str.charAt(idx) != ' ') {
            c = c + 1; // (counter is only increased if other character than ' ' is found )

            if (str.charAt(idx - 1) == ' ') {
                return c; // (count is returned if the ' ' found after the character)
            }
        }
        return last(str, idx - 1, c);

    }

}
