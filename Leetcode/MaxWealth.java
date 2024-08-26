// https://leetcode.com/problems/richest-customer-wealth/description/
package Leetcode;

public class MaxWealth {

    public static void main(String[] args) {
        int accounts[][] = {
                { 1, 2, 3 },
                { 3, 2, 1 }
        };
        System.out.println(maximumWealth(accounts));

    }

    static int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int arrsum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                arrsum += accounts[i][j];
            }
            if (arrsum > maxWealth) {
                maxWealth = arrsum;
            }

        }
        return maxWealth;

    }

}
