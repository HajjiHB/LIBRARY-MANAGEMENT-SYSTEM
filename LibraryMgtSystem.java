import java.util.ArrayList;
import java.util.Scanner;

public class LibraryMgtSystem {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library();
        int password = 1234;
        String AdminUsername = "Admin";

        System.out.println("WELCOME TO THE LIBRARY MANAGEMENT SYSTEM");

        System.out.println("ENTER USERNAME");
        AdminUsername = input.nextLine();
        if(AdminUsername =="Admin") {
            System.out.println("PROCEED");
        }
        else{
            System.out.println("WRONG USERNAME");
            System.out.println("RE-ENTER USERNAME");
            AdminUsername = input.nextLine();
        }
        System.out.println("ENTER PASSWORD");
        password = input.nextInt();

        if(password == 12345){
            System.out.println("PROCEED");

        }
        else{
            System.out.println("WRONG PASSWORD");
            System.out.println("RE-ENTER PASSWORD");
            password = input.nextInt();

        }


        while (true) {
            System.out.println("LOG IN SUCCESSFUL");
            System.out.println("Library Management System!");

            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search book");
            System.out.println("4. Display all books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = input.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = input.next();
                    System.out.print("Enter book author: ");
                    String author = input.next();
                    Book book = new Book(title, author);
                    library.addBook(book);
                    System.out.println("Book added successfully!");
                    break;
                    
                case 2:
                    System.out.print("Enter book title: ");
                    title = input.next();
                    book = library.searchBook(title);
                    if (book != null) {
                        library.removeBook(book);
                        System.out.println("Book removed successfully!");
                    }
                    else {
                        System.out.println("Book not found!");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter book title: ");
                    title = input.next();
                    book = library.searchBook(title);
                    if (book != null) {
                        System.out.println("Book found:");
                        System.out.println(book);
                    }
                    else {
                        System.out.println("Book not found!");
                    }
                    break;
                    
                case 4:
                    ArrayList<Book> books = library.getAllBooks();
                    if (books.size() > 0) {
                        System.out.println("All books:");
                        for (Book b : books) {
                            System.out.println(b);
                        }
                    }
                    else {
                        System.out.println("No books in library!");
                    }
                    break;
                    
                case 5:
                    System.out.println("Goodbye!");
                    input.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            
            System.out.println();
        }
    }

}

class Library {
    
    private ArrayList<Book> books;
    
    public Library() {
        books = new ArrayList<Book>();
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public void removeBook(Book book) {
        books.remove(book);
    }
    
    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    
    public ArrayList<Book> getAllBooks() {
        return books;
    }
    
}

class Book {
    
    private String title;
    private String author;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
    
}