package String;

public class subsequence {

    public static void main(String[] args) {
        subsequence(" ", "abcd");
    }

    static void subsequence(String e, String str) {
        if (str.isEmpty()) {
            System.out.println(e);
            return;
        }
        char ch = str.charAt(0);
        subsequence(e + ch, str.substring(1));
        subsequence(e, str.substring(1));
    }
}
/*
 * This program gives the subsequence of a string. Function takes two arguments,
 * empty string 'e' and a string 'str' whose subsequence is to be found. In two
 * recusive calls, one will add the first character of the string in the empty
 * string and another will just ignore the character. When the original string
 * is empty we will have all the subsequences stored in the empty string of each
 * recursive call.
 */