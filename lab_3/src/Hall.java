import java.util.*;

public class Hall {
    private final String name;
    private final int rows;
    private final int seatsPerRow;
    private final List<MovieSession> sessions = new ArrayList<>();

    public Hall(String name, int rows, int seatsPerRow) {
        this.name = name;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
    }

    public String getName() {
        return name;
    }

    public int getRows() {
        return rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void addSession(MovieSession session) {
        sessions.add(session);
    }

    public List<MovieSession> getSessions() {
        return sessions;
    }

    public MovieSession selectSession() {
        if (sessions.isEmpty()) {
            System.out.println("Нет доступных сеансов.");
            return null;
        }
        for (int i = 0; i < sessions.size(); i++) {
            System.out.println((i + 1) + ". " + sessions.get(i).getInfo());
        }
        System.out.print("Выберите сеанс: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index < 1 || index > sessions.size()) return null;
        return sessions.get(index - 1);
    }
}
