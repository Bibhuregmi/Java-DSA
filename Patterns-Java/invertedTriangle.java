public class invertedTriangle {

    public static void main(String[] args) {

        Invertedtriangle(4, 0);
        triangle(4, 0);

    }

    static void Invertedtriangle(int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            System.out.print("*");
            Invertedtriangle(r, c + 1);
        } else {
            System.out.println();
            Invertedtriangle(r - 1, 0);
        }
    }

    static void triangle(int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            triangle(r, c + 1);
            System.out.print("*");
        } else {
            triangle(r - 1, 0);
            System.out.println();
        }
    }
}

/*
 * What is the difference of these two function?
 * -> The `Invertedtriangle` function prints the stars during the recursive
 * calls,
 * printing each row of stars immediately before moving to the next row.
 * It builds the output top-down as it recurses.
 * 
 * The `triangle` function, however, defers printing until the recursion
 * completes,
 * meaning all recursive calls execute first, and stars are printed when the
 * function
 * calls return (unwind from the stack). This results in stars being printed
 * bottom-up as the recursion unwinds.
 */
