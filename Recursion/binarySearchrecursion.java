package Recursion;

public class binarySearchrecursion {

    public static void main(String[] args) {
        int arr[] = { 90, 78, 66, 55, 44, 33, 25, 19, 12, 8, 4, 1 };
        int target = 12;
        System.out.println(search(arr, target, 0, arr.length - 1));

    }

    static int search(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return search(arr, target, start, mid - 1);
        }
        return search(arr, target, mid + 1, end);
    }
}
/*
 * Here is the concept of the binary search with recursion, on every function
 * call new sub array is passed with the start and end so it is really imporant
 * to have start and end in the arguments. Similarly, if there are other
 * variables that is required for the function call, it goes in the argument of
 * the function. Besides that all the variables goes on the body of the function
 * (like mid) which changes on each function call. Another important thing is
 * the return statement beacuse it need to return its value to the function it
 * was called by. If there is no return statement no value will be returned.
 * 
 * So the most important things are
 * 1. Sub array Handling (correctly updates start and end for the current
 * recursive call)
 * 2. Function argument (start and end in the arguments and other essential
 * variables like target)
 * 3. Variable in fuction body (that changes in each computation like mid)
 * 4. Return statement (Must return a value from each call so that result is
 * determined)
 */