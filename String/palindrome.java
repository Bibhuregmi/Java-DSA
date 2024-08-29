package String;

public class palindrome {

    public static void main(String[] args) {
        String str = "";
        System.out.println(ispalindrome(str));

    }

    static boolean ispalindrome(String str) {
        str = str.toLowerCase();

        char s = str.charAt(0);
        char e = str.charAt(str.length() - 1);

        if (str.length() == 0 || str == null) {
            return true;
        }
        while (s < e) {
            if (s != e) {
                return false;
            } else {
                s++;
                e--;
            }
        }
        return true;

    }
}

/*
 * Using two pointer method to check whether the string is palindorme or not.
 * First pointer starts at the index 0 of the stirng and last pointer at the end
 * and if the condition satisfies it returns true else the points moves forward
 * and backward respectively.
 */