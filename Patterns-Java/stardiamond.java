public class stardiamond {
    public static void main(String[] args) {
        int n = 7;
        for (int i = 1; i <= n; i += 2) {
            for (int j = 1; j <= (n - i) / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                if (i % 2 == 1) {
                    System.out.print("*");
                } else {
                    break;
                }
            }
            System.out.println();
        }

        for (int i = n; i >= 1; i -= 2) {
            for (int j = 1; j <= (n - i) / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                if (i % 2 == 1) {
                    System.out.print("*");
                } else {
                    break;
                }
            }
            System.out.println();
        }
    }
}
