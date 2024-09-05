package Recursion;

//This is the recursive way to check if the array is sorted or not. Iterative way in (/Array/checksort.java)
public class sortedArray {

    public static void main(String[] args) {
        int arr[] = { 2, 4, 5, 6, 7 };
        System.out.println(checkSort(arr, 0));
    }

    static boolean checkSort(int[] arr, int indx) {
        if (indx == arr.length - 1) {
            return true;
        }
        if (arr[indx] < arr[indx + 1]) {
            return checkSort(arr, indx + 1);
        }
        return false;
        // return arr[indx] < arr[indx+1] && checksort(arr, indx+1);
    }
}
/*
 * checkSort([2,4,5,6,7], 0) -> (checks first and second)
 *    checkSort([2,4,5,6,7], 1) -> (checks second and third)
 *       checkSort([2,4,5,6,7], 2) -> (check third and fourth)
 *          checkSort([2,4,5,6,7], 3) -> (checks fourth and fifth)
 *             checkSort([2,4,5,6,7] ,4) -> base condition -> returns true to the above function.
 */
