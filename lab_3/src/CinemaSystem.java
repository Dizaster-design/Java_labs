import java.util.*;

public class CinemaSystem {
    private final List<Cinema> cinemas = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addCinema() {
        System.out.print("Введите название кинотеатра: ");
        String name = scanner.nextLine();
        cinemas.add(new Cinema(name));
        System.out.println("Кинотеатр добавлен.");
    }

    public void addHallToCinema() {
        Cinema cinema = selectCinema();
        if (cinema == null) return;
        System.out.print("Введите имя зала: ");
        String hallName = scanner.nextLine();
        System.out.print("Введите количество рядов: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество мест в ряду: ");
        int seats = scanner.nextInt();
        scanner.nextLine();
        cinema.addHall(new Hall(hallName, rows, seats));
        System.out.println("Зал добавлен.");
    }

    public void createSession() {
        Cinema cinema = selectCinema();
        if (cinema == null) return;
        Hall hall = cinema.selectHall();
        if (hall == null) return;
        System.out.print("Введите название фильма: ");
        String movie = scanner.nextLine();
        System.out.print("Введите дату и время (например, 2025-05-11 18:00): ");
        String time = scanner.nextLine();
        hall.addSession(new MovieSession(movie, time, hall.getRows(), hall.getSeatsPerRow()));
        System.out.println("Сеанс создан.");
    }

    public void buyTicket() {
        Cinema cinema = selectCinema();
        if (cinema == null) return;
        Hall hall = cinema.selectHall();
        if (hall == null) return;
        MovieSession session = hall.selectSession();
        if (session == null) return;

        session.printSeats();
        System.out.print("Введите ряд: ");
        int row = scanner.nextInt();
        System.out.print("Введите место: ");
        int seat = scanner.nextInt();
        scanner.nextLine();

        if (session.bookSeat(row - 1, seat - 1)) {
            System.out.println("Билет успешно куплен!");
        } else {
            System.out.println("Место уже занято или некорректно.");
        }
    }

    public void findNearestSession() {
        System.out.print("Введите название фильма: ");
        String movie = scanner.nextLine();
        for (Cinema cinema : cinemas) {
            for (Hall hall : cinema.getHalls()) {
                for (MovieSession session : hall.getSessions()) {
                    if (session.getMovie().equalsIgnoreCase(movie) && session.hasFreeSeats()) {
                        System.out.println("Ближайший сеанс: " + session.getInfo() +
                                ", Кинотеатр: " + cinema.getName() +
                                ", Зал: " + hall.getName());
                        return;
                    }
                }
            }
        }
        System.out.println("Сеансов с этим фильмом нет или нет свободных мест.");
    }

    public void printHallPlan() {
        Cinema cinema = selectCinema();
        if (cinema == null) return;
        Hall hall = cinema.selectHall();
        if (hall == null) return;
        MovieSession session = hall.selectSession();
        if (session == null) return;
        session.printSeats();
    }

    private Cinema selectCinema() {
        if (cinemas.isEmpty()) {
            System.out.println("Нет доступных кинотеатров.");
            return null;
        }
        for (int i = 0; i < cinemas.size(); i++) {
            System.out.println((i + 1) + ". " + cinemas.get(i).getName());
        }
        System.out.print("Выберите кинотеатр: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index < 1 || index > cinemas.size()) return null;
        return cinemas.get(index - 1);
    }
}
