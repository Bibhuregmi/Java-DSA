import java.util.*;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        if (num1 == num2) {
            System.out.println("Equal");
        } else if (num1 > num2) {
            System.out.println("First number is greater");
        } else {
            System.out.println("First number is small than second number");
        }
    }

}
