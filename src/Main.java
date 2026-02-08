import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("年齢を入力: ");
        String input = sc.nextLine();

        try {
            int age = Integer.parseInt(input);
            if (age >= 20) {
                System.out.println("成人です");
            } else {
                System.out.println("未成年です");
            }
        } catch (NumberFormatException e) {
            System.out.println("数字を入力してね");
        }
    }
}
