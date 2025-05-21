import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private Set<String> uniqueAuthors = new HashSet<>();
    private Map<String, Integer> authorCount = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        uniqueAuthors.add(book.getAuthor());
        authorCount.put(book.getAuthor(), authorCount.getOrDefault(book.getAuthor(), 0) + 1);
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            int count = authorCount.get(book.getAuthor()) - 1;
            if (count == 0) {
                authorCount.remove(book.getAuthor());
                uniqueAuthors.remove(book.getAuthor());
            } else {
                authorCount.put(book.getAuthor(), count);
            }
            System.out.println("Книга удалена: " + book);
        } else {
            System.out.println("Книга не найдена: " + book);
        }
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }
        }
        return result;
    }

    public List<Book> findBooksByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getYear() == year) {
                result.add(b);
            }
        }
        return result;
    }

    public void printAllBooks() {
        System.out.println("Все книги в библиотеке:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void printUniqueAuthors() {
        System.out.println("Уникальные авторы:");
        for (String author : uniqueAuthors) {
            System.out.println(author);
        }
    }

    public void printAuthorStatistics() {
        System.out.println("Статистика по авторам:");
        for (Map.Entry<String, Integer> entry : authorCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " книг(и)");
        }
    }
}