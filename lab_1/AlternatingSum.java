import java.util.Scanner;

public class AlternatingSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (i % 2 == 0) {
                sum += num;
            } else {
                sum -= num;
            }
        }
        
        System.out.println(sum);
    }
}