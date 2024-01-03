import java.util.Scanner;

// Book class to model individual books
class Book {
    private final int bookId;
    private final String title;
    private final String author;
    private boolean isAvailable;

    // Constructor to initialize a book with given attributes
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getter methods
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter method to update availability status
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

// Library class to manage a collection of books
class Library {
    private final Book[] books;
    private int size;
    private static final int MAX_SIZE = 100;

    // Constructor to initialize the library with an array of books
    public Library() {
        this.books = new Book[MAX_SIZE];
        this.size = 0;
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        if (size < MAX_SIZE) {
            books[size++] = book;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Method to remove a book from the library
    public void removeBook(int bookId) {
        for (int i = 0; i < size; i++) {
            if (books[i].getBookId() == bookId) {
                books[i].setAvailable(false);
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }

    // Method to search for a book by its ID
    public void searchBook(int bookId) {
        for (int i = 0; i < size; i++) {
            if (books[i].getBookId() == bookId) {
                System.out.println("Book found:");
                System.out.println("Book ID: " + books[i].getBookId());
                System.out.println("Title: " + books[i].getTitle());
                System.out.println("Author: " + books[i].getAuthor());
                System.out.println("Availability: " + (books[i].isAvailable() ? "Available" : "Not Available"));
                return;
            }
        }
        System.out.println("Book not found in the library.");
    }

    // Method to display all books in the library
    public void displayBooks() {
        if (size == 0) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (int i = 0; i < size; i++) {
                System.out.println("Book ID: " + books[i].getBookId() +
                        ", Title: " + books[i].getTitle() +
                        ", Author: " + books[i].getAuthor() +
                        ", Availability: " + (books[i].isAvailable() ? "Available" : "Not Available"));
            }
        }
    }
}

// Main class to demonstrate the library system
public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();

                    Book newBook = new Book(bookId, title, author);
                    library.addBook(newBook);
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeBookId = scanner.nextInt();
                    library.removeBook(removeBookId);
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchBookId = scanner.nextInt();
                    library.searchBook(searchBookId);
                    break;

                case 4:
                    library.displayBooks();
                    break;

                case 5:
                    System.out.println("Exiting the Library System. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
