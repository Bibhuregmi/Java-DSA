package String;

public class phoneLetter {

    public static void main(String[] args) {
        phonepad(" ", "12");
    }

    static void phonepad(String e, String str) {
        if (str.isEmpty()) {
            System.out.println(e);
            return;
        }

        int digit = str.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < (digit * 3); i++) {
            char ch = (char) ('a' + i);
            phonepad(e + ch, str.substring(1));
        }

    }
}
