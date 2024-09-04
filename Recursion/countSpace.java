package Recursion;

public class countSpace {

    public static void main(String[] args) {
        String str = "My name is Bibhu";
        int ans = space(str, 0, 0);
        System.out.println(ans);
    }

    static int space(String str, int idx, int c) {
        if (idx == str.length()) {
            return c;
        }
        if (str.charAt(idx) == ' ') {
            c = c + 1; // incresing count if space is found
        }
        return space(str, idx + 1, c); // incresing the value of index to check other character.
    }
}
