//https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
package Leetcode;

public class qsevenfourtyfour {
    public static void main(String[] args) {
        char letters[] = { 'c', 'f', 'j' };
        char target = 'c';
        System.out.println(strSearch(letters, target));
    }

    static char strSearch(char letters[], char target) {
        int s = 0;
        int e = letters.length - 1;

        while (s <= e) {

            int mid = s + (e - s) / 2;
            if (target == letters[mid]) {
                return (char) mid;
            }

            if (target > letters[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }

        }
        return letters[s % letters.length];
    }
}
