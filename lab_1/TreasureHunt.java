import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        int treasureX = scanner.nextInt();
        int treasureY = scanner.nextInt();
        scanner.nextLine(); 
        
        int currentX = 0, currentY = 0;
        int instructionCount = 0;
        int result = -1; 
        
        while (true) {
            String direction = scanner.nextLine().trim();
            
            if (direction.equalsIgnoreCase("стоп")) {
                break;
            }
            
            if (!direction.equals("север") && 
                !direction.equals("юг") && 
                !direction.equals("запад") && 
                !direction.equals("восток")) {
                continue; 
            }
            
            int steps = scanner.nextInt();
            scanner.nextLine(); 
            
            instructionCount++;
            
            switch (direction) {
                case "север": currentY += steps; break;
                case "юг": currentY -= steps; break;
                case "восток": currentX += steps; break;
                case "запад": currentX -= steps; break;
            }
            
            if (currentX == treasureX && currentY == treasureY && result == -1) {
                result = instructionCount;
            }
        }
        
        System.out.println(result);
        scanner.close();
    }
}