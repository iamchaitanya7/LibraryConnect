# LibraryConnect: Library Management System

This project, LibraryConnect, is a library management system implemented using Hibernate and Java. It provides functionalities to manage books, authors, and borrowers, including adding, updating, deleting, and retrieving information.

## Features

* **Book Management:**
    * Add new books with title, ISBN, price, and associated author.
    * Update existing book information.
    * Delete books.
    * View all books.
    * Search books by title keyword.
    * View the most expensive book.
* **Author Management:**
    * Add new authors with name and email.
    * View books by a specific author.
* **Borrower Management:**
    * Add new borrowers with name and email.
    * View borrowers of a specific book.

## Technologies Used

* **Java:** Programming language for application logic.
* **Hibernate:** ORM framework for database interaction.
* **MySQL:** Database for storing library information.
* **Maven:** Build tool for dependency management.

## Setup Instructions

1. **Database Setup:**
    * Create a MySQL database (assume a suitable name).
    * Configure the database connection in `hibernate.cfg.xml` (create one based on your database details).  This file should be placed in the `src/main/resources` directory.  It should include mappings for `Book.java`, `Author.java`, and `Borrower.java`.
2. **Build:**
    * Use Maven to build the project and resolve dependencies. You'll need a `pom.xml` file listing the Hibernate and MySQL connector dependencies.
3. **Run:**
    * Compile and run the `LibraryConnectApp.java` class to start the application.

## Usage

The application provides a menu-driven command-line interface. Follow the on-screen prompts to perform various operations.  Input validation is minimal in the provided code.

## Code Structure

* **`com.jbk.entities`:** Contains entity classes representing database tables (`Book`, `Author`, `Borrower`).
* **`com.jbk.operations`:** Contains the `dbOperations` class responsible for database operations.
* **`com.jbk.config`:** Contains the `HibernateUtil` class for obtaining the `SessionFactory`.
* **`com.jbk.LibraryConnectApp`:** Main application class.

## Future Enhancements

* **Improved User Interface:** Implement a graphical user interface (GUI) for better user experience.
* **Robust Input Validation:** Add comprehensive input validation to prevent errors and improve data integrity.
* **Advanced Search:** Implement more complex search queries.
* **Reporting:** Generate reports on library data, such as borrowed books, popular authors, etc.
* **User Authentication and Authorization:** Implement user roles and access control.
* **Exception Handling:** Implement robust exception handling to gracefully manage errors and provide informative feedback to the user.  The provided code has placeholder exception classes, but they are not used.


## Contributing

Contributions are welcome. Please fork the repository and submit pull requests.

## License

This project is licensed under the MIT License.
