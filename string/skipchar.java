package string;

public class skipchar {

    public static void main(String[] args) {
        String str = "baccad";
        skip(" ", str);
    }

    static void skip(String p, String str) {
        if (str.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = str.charAt(0);
        if (ch == 'a') {
            skip(p, str.substring(1));
        } else {
            skip(p + ch, str.substring(1));
        }
    }

}
