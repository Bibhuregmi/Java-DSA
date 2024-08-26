import java.util.*;

public class calculator {
    public static void main(String[] args, int calc) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        switch (calc) {
            case 1:
                System.out.println(a + b);
                break;
            case 2:
                System.out.println(a - b);
                break;
            case 3:
                if (b == 0) {
                    System.out.println("Invalid operation");
                } else {
                    System.out.println(a / b);
                }
                break;
            case 4:
                System.out.println(a * b);
                break;
            case 5:
                if (b == 0) {
                    System.out.println("Invalid operation");
                } else {
                    System.out.println(a % b);

                }
            default:
                System.out.println("Choose number between 1 and 5");

        }
    }
}
