import java.util.Scanner;

public class TwiceEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        
        if (number < 100 || number > 999) {
            System.out.println("Число должно быть трехзначным");
            return;
        }
        
        int digit1 = number / 100;
        int digit2 = (number / 10) % 10;
        int digit3 = number % 10;
        
        int sum = digit1 + digit2 + digit3;
        int product = digit1 * digit2 * digit3;
        
        if (sum % 2 == 0 && product % 2 == 0) {
            System.out.println("да");
        } else {
            System.out.println("нет");
        }
    }
}