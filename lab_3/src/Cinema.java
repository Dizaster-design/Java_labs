import java.util.*;

public class Cinema {
    private final String name;
    private final List<Hall> halls = new ArrayList<>();

    public Cinema(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addHall(Hall hall) {
        halls.add(hall);
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public Hall selectHall() {
        if (halls.isEmpty()) {
            System.out.println("Нет доступных залов.");
            return null;
        }
        for (int i = 0; i < halls.size(); i++) {
            System.out.println((i + 1) + ". " + halls.get(i).getName());
        }
        System.out.print("Выберите зал: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index < 1 || index > halls.size()) return null;
        return halls.get(index - 1);
    }
}
