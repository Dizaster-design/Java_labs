import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static CinemaSystem system = new CinemaSystem();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Добро пожаловать в билетную систему!");
            System.out.println("1. Вход как администратор");
            System.out.println("2. Вход как пользователь");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка

            switch (choice) {
                case 1 -> adminLogin();
                case 2 -> userMenu();
                case 0 -> {
                    System.out.println("Выход из программы.");
                    return;
                }
                default -> System.out.println("Неверный выбор.");
            }
        }
    }

    private static void adminLogin() {
        System.out.print("Введите логин администратора: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        if (login.equals("Camper02") && password.equals("IwantZachet")) {
            adminMenu();
        } else {
            System.out.println("Неверные учетные данные.");
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n=== Администратор ===");
            System.out.println("1. Добавить кинотеатр");
            System.out.println("2. Добавить зал в кинотеатр");
            System.out.println("3. Создать сеанс");
            System.out.println("0. Назад");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> system.addCinema();
                case 2 -> system.addHallToCinema();
                case 3 -> system.createSession();
                case 0 -> { return; }
                default -> System.out.println("Неверный выбор.");
            }
        }
    }

    private static void userMenu() {
        while (true) {
            System.out.println("\n=== Пользователь ===");
            System.out.println("1. Купить билет");
            System.out.println("2. Найти ближайший сеанс по фильму");
            System.out.println("3. Показать план зала");
            System.out.println("0. Назад");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> system.buyTicket();
                case 2 -> system.findNearestSession();
                case 3 -> system.printHallPlan();
                case 0 -> { return; }
                default -> System.out.println("Неверный выбор.");
            }
        }
    }
}