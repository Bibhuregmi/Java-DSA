// For the 3X3 maze, give all the possible ways to reach from point (0,0) to (3,3) if the person can 
// only move right or down. 

package Recursion;

import java.util.ArrayList;

public class maze {
    public static void main(String[] args) {
        // System.out.println(ways(3, 3));
        // System.out.println(path(" ", 3, 3));
        System.out.println(pathDiagonal(" ", 3, 3));
    }

    static int ways(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = ways(r - 1, c);
        int right = ways(r, c - 1);
        int diagonal = ways(r - 1, c - 1); // Added to check the diagonal ways.
        return left + right + diagonal;
    }

    // Now return the path in a arraylist it can follow to reach the destination.
    static ArrayList<String> path(String e, int r, int c) {

        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(e);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (r > 1) {
            ans.addAll(path(e + "D", r - 1, c));
        }
        if (c > 1) {
            ans.addAll(path(e + "R", r, c - 1));
        }
        return ans;
    }

    // What if you could go diagonally?
    static ArrayList<String> pathDiagonal(String e, int r, int c) {

        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(e);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (r > 1) {
            ans.addAll(pathDiagonal(e + "D", r - 1, c));
        }
        if (c > 1) {
            ans.addAll(pathDiagonal(e + "R", r, c - 1));
        }
        if (r > 1 && c > 1) {
            ans.addAll(pathDiagonal(e + "di", r - 1, c - 1));
        }
        return ans;
    }

}