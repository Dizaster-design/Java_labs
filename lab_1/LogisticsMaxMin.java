import java.util.Scanner;

public class LogisticsMaxMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roads = scanner.nextInt();
        int bestRoad = 0;
        int maxHeight = 0;
        
        for (int i = 0; i < roads; i++) {
            int tunnels = scanner.nextInt();
            int minTunnelHeight = Integer.MAX_VALUE;
            
            for (int j = 0; j < tunnels; j++) {
                int height = scanner.nextInt();
                if (height < minTunnelHeight) {
                    minTunnelHeight = height;
                }
            }
            
            if (minTunnelHeight > maxHeight) {
                maxHeight = minTunnelHeight;
                bestRoad = i + 1;
            }
        }
        
        System.out.println(bestRoad + " " + maxHeight);
    }
}