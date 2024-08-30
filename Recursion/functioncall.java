package Recursion;

public class functioncall {

    public static void main(String[] args) {
        print1(1);
    }

    static void print1(int n) {
        System.out.println(n);
        print2(2);
    }

    static void print2(int n) {
        System.out.println(n);
        print3(3);
    }

    static void print3(int n) {
        System.out.println(n);
        print4(4);
    }

    static void print4(int n) {
        System.out.println(n);
        print5(5);
    }

    static void print5(int n) {
        System.out.println(n);
    }

}

/*
 * All the function call happens in the stack memory. And it will remain in the
 * stack till it is not finished executing. When a function is finished
 * executing it is removed form the stack and flow of the program is restored to
 * where that function was called. Or in the simple term, when a function is
 * executed it will return to the point where it was called.
 * 
 * On debugging the program we can see the function in the stack and how it is
 * removed once its done execting and where the flow of program is
 */