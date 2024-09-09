package String;

import java.util.DoubleSummaryStatistics;

public class permutation {

    public static void main(String[] args) {
        permutation("", "abc");
    }

    static void permutation(String e, String str) {

        if (str.isEmpty()) {
            System.out.println(e);
            return;
        }
        char ch = str.charAt(0);
        for (int i = 0; i <= e.length(); i++) {
            String f = e.substring(0, i);
            String s = e.substring(i, e.length());
            permutation(f + ch + s, str.substring(1));
        }

    }
}

/*
 * This method uses recursion to find the permutations of the given string. A
 * simple logic is that insted of ignoring a character as in the subsequence, we
 * will add it to the empty string. Here the recursion call is depended to the
 * size of the empty string hence for loop is used which iterates over each possible
 * position where new character can be added. 
 * 
 *                                     permutation ("", abc) 
 *                                       (1 function call)
 *                                     permutation ("a", bc)
 *                                       (2 function call)
 *               permutation("ab" , c)                                  permutation("ba", c)
 *             
 *                  (3 function call)                                              (3 function call)   
 * permutation("cab","")permutation("acb","")permutation("abc","") | permutation("cba","")permutation("bca","")permutation("bac","")
 * 
 * 
 */
