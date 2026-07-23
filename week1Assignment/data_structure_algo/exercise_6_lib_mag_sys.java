import java.util.Arrays;
import java.util.Comparator;

class Book {

    int bookId;
    String title;
    String author;

    // Constructor
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Display Book Details
    public void display() {
        System.out.println("Book ID : " + bookId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("--------------------------");
    }
}

public class exercise_6_lib_mag_sys {

    // Linear Search by Title
    public static Book linearSearch(Book[] books, String title) {

        for (Book book : books) {

            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    // Binary Search by Title
    public static Book binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(title);

            if (result == 0) {
                return books[mid];
            }

            else if (result < 0) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Book[] books = {

                new Book(101, "Java Programming", "James Gosling"),
                new Book(102, "Data Structures", "Mark Allen"),
                new Book(103, "Operating Systems", "Abraham Silberschatz"),
                new Book(104, "Computer Networks", "Andrew Tanenbaum"),
                new Book(105, "Database Systems", "Raghu Ramakrishnan")

        };

        String searchTitle = "Data Structures";

        // Linear Search
        System.out.println("Linear Search Result\n");

        Book book1 = linearSearch(books, searchTitle);

        if (book1 != null)
            book1.display();
        else
            System.out.println("Book not found.");

        // Sort array by title for Binary Search
        Arrays.sort(books, Comparator.comparing(book -> book.title));

        // Binary Search
        System.out.println("\nBinary Search Result\n");

        Book book2 = binarySearch(books, searchTitle);

        if (book2 != null)
            book2.display();
        else
            System.out.println("Book not found.");
    }
}