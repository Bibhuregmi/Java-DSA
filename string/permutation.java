package string;

import java.util.ArrayList;

public class permutation {

    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>(permutationofString("", "abcd", 1));
        System.out.println(result);
    }

    static ArrayList<String> permutationofString(String e, String str, int c) {

        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(e + ": " + c);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= e.length(); i++) {
            String f = e.substring(0, i);
            String s = e.substring(i, e.length());
            ans.addAll(permutationofString(f + ch + s, str.substring(1), c));
            c += permutationofString(f + ch + s, str.substring(1), c).size();
            // ^^ Here since, c being int and our return type being ArrayList, we can't
            // directly add them together so the logical way is that we
            // need to add the size of the list returned by permutation() to increse the
            // count.
            // and the list starts form index 0, we start our count from 1.
        }
        return ans;

    }
}

/*
 * This method uses recursion to find the permutations of the given string. A
 * simple logic is that insted of ignoring a character as in the subsequence, we
 * will add it to the empty string. Here the recursion call is depended to the
 * size of the empty string hence for loop is used which iterates over each
 * possible position where new character can be added.
 * 
 * Changes made -> Changed the return type to ArrayList so it returns the answer
 * in the form of ArrayList.
 */
