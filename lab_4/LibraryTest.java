public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library();

        // Добавление книг
        library.addBook(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));
        library.addBook(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        library.addBook(new Book("Идиот", "Фёдор Достоевский", 1869));
        library.addBook(new Book("Скотный двор", "Джордж Оруэлл", 1945));

        System.out.println();
        library.printAllBooks();

        System.out.println();
        library.printUniqueAuthors();

        System.out.println();
        library.printAuthorStatistics();

        System.out.println();
        System.out.println("Книги Достоевского:");
        for (Book b : library.findBooksByAuthor("Фёдор Достоевский")) {
            System.out.println(b);
        }

        System.out.println();
        System.out.println("Книги 1945 года:");
        for (Book b : library.findBooksByYear(1945)) {
            System.out.println(b);
        }

        System.out.println();
        library.removeBook(new Book("Идиот", "Фёдор Достоевский", 1869));

        System.out.println();
        library.printAllBooks();

        System.out.println();
        library.printAuthorStatistics();
    }
}