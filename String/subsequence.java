package String;

import java.util.ArrayList;

public class subsequence {

    public static void main(String[] args) {
        System.out.println(subsequence(" ", "abcd"));

    }

    static ArrayList<String> subsequence(String e, String str) {
        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(e);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> left = subsequence(e + ch, str.substring(1));
        ArrayList<String> right = subsequence(e, str.substring(1));

        left.addAll(right);
        return left;
    }
}
/*
 * Base Case:
 * - If the input string `str` is empty, the method creates a new `ArrayList`,
 * adds the current subsequence `e` to it, and returns this list. This
 * represents the end of a branch in the recursion tree where no more characters
 * are left to process.
 * Recursive Case:
 * - The method processes the first character of `str`, which is stored in `ch`.
 * - It recursively generates all subsequences including this character by
 * calling `subsequence(e + ch, str.substring(1))`. This updates `e` by adding
 * `ch` and processes the remaining string.
 * - It recursively generates all subsequences excluding this character by
 * calling `subsequence(e, str.substring(1))`. This keeps `e` unchanged and
 * processes the remaining string.
 * Combining Results:
 * - The results from the two recursive calls (`left` and `right`) are combined.
 * `left` contains all subsequences that include the current character `ch`,
 * while `right` contains all subsequences that do not include `ch`.
 * - The method adds all subsequences from `right` to the `left` list and
 * returns this combined list.
 */