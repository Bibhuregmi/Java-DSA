package Recursion;

import java.util.ArrayList;

public class diceThrow {

    public static void main(String[] args) {
        dice(" ", 4);
        System.out.println(diceComb(" ", 5));
    }

    static void dice(String e, int target) {
        if (target == 0) {
            System.out.println(e);
            return;
        }
        for (int i = 1; i <= target; i++) {
            dice(e + i, target - i);
        }
    }

    static ArrayList<String> diceComb(String e, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(e);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            ans.addAll(diceComb(e + i, target - i));

        }
        return ans;
    }
}
