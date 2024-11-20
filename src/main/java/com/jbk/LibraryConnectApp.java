package com.jbk;

import com.jbk.entities.Author;
import com.jbk.entities.Book;
import com.jbk.entities.Borrower;
import com.jbk.operations.dbOperations;
import java.util.List;
import java.util.Scanner;

public class LibraryConnectApp {
    private static final dbOperations dbOperations = new dbOperations ();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Author");
            System.out.println("3. Add Borrower");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. View All Books");

            System.out.println("7. View Books by Author");
            System.out.println("8. View Borrowers of a Book");
            System.out.println("9. View Most Expensive Book");
            System.out.println("10. Search Books by Title Keyword");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 : addBook();
                case 2 : addAuthor();
                case 3 : addBorrower();
                case 4 : updateBook();
                case 5 : deleteBook();
                case 6 : viewAllBooks();
                case 7 : viewBooksByAuthor();
                case 8 : viewBorrowersOfBook();
                case 9 : viewMostExpensiveBook();
                case 10 : searchBooksByTitleKeyword();
                case 0 : System.out.println("Exiting system. Goodbye!");
                default : System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void addBook() {
        System.out.print("Enter Book Title: ");
        String title = scanner.next();
        System.out.print("Enter Book ISBN: ");
        long isbn = scanner.nextLong ();
        System.out.print("Enter Book Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Author ID: ");
        int authorId = scanner.nextInt();
        Author author = dbOperations.getEntityById(Author.class, authorId);

        if (author != null) {
            Book book = new Book(title, isbn, price, author);
            dbOperations.addEntity(book);
        } else {
            System.out.println("Author with ID " + authorId + " not found!");
        }
    }

    private static void addAuthor() {
        System.out.print("Enter Author Name: ");
        String name = scanner.next();
        System.out.print("Enter Author Email: ");
        String email = scanner.next();
        Author author = new Author(name, email);
        dbOperations.addEntity(author);
    }

    private static void addBorrower() {
        System.out.print("Enter Borrower Name: ");
        String name = scanner.next();
        System.out.print("Enter Borrower Email: ");
        String email = scanner.next();
        Borrower borrower = new Borrower(name, email);
        dbOperations.addEntity(borrower);
    }

    private static void updateBook() {
        System.out.print("Enter Book ID to Update: ");
        int bookId = scanner.nextInt();

        Book book = dbOperations.getEntityById(Book.class, bookId);
        if (book != null) {
            System.out.print("Enter New Title (Current: " + book.getTitle() + "): ");
            String title = scanner.next();
            System.out.print("Enter New ISBN (Current: " + book.getIsbn() + "): ");
            long isbn = scanner.nextLong ();
            System.out.print("Enter New Price (Current: " + book.getPrice() + "): ");
            double price = scanner.nextDouble();

            book.setTitle(title);
            book.setIsbn(isbn);
            book.setPrice(price);

            dbOperations.updateEntity(book);
        } else {
            System.out.println("Book with ID " + bookId + " not found!");
        }
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to Delete: ");
        int bookId = scanner.nextInt();

        Book book = dbOperations.getEntityById(Book.class, bookId);
        if (book != null) {
            dbOperations.deleteEntity(book);
        } else {
            System.out.println("Book with ID " + bookId + " not found!");
        }
    }

    private static void viewAllBooks() {
        List<Book> books = dbOperations.getAllEntities(Book.class);
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void viewBooksByAuthor() {
        System.out.print("Enter Author ID: ");
        int authorId = scanner.nextInt();

        List<Book> books = dbOperations.fetchBooksByAuthor(authorId);
        if (books.isEmpty()) {
            System.out.println("No books found for the specified author.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void viewBorrowersOfBook() {
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        List<Borrower> borrowers = dbOperations.fetchBorrowersByBook(bookId);
        if (borrowers.isEmpty()) {
            System.out.println("No borrowers found for the specified book.");
        } else {
            borrowers.forEach(System.out::println);
        }
    }

    private static void viewMostExpensiveBook() {
        Book book = dbOperations.fetchMostExpensiveBook();
        if (book != null) {
            System.out.println("Most Expensive Book: " + book);
        } else {
            System.out.println("No books found.");
        }
    }

    private static void searchBooksByTitleKeyword() {
        System.out.print("Enter Title Keyword: ");
        String keyword = scanner.nextLine();

        List<Book> books = dbOperations.fetchBooksByTitleKeyword(keyword);
        if (books.isEmpty()) {
            System.out.println("No books found with the specified keyword.");
        } else {
            books.forEach(System.out::println);
        }
    }
}
