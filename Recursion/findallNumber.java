package Recursion;

import java.util.ArrayList;

public class findallNumber {

    public static void main(String[] args) {
        int arr[] = { 3, 52, 45, 234, 23, 34, 23, 12 };
        System.out.println(findAll(arr, 23, 0, new ArrayList<>()));
    }

    static ArrayList<Integer> findAll(int[] arr, int target, int i, ArrayList<Integer> list) {
        if (i == arr.length) {
            return list;
        }
        if (arr[i] == target) {
            list.add(i);
        }
        return findAll(arr, target, i + 1, list);
    }
}
