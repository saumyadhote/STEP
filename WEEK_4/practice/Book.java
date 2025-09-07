public class Book {
    String title;
    String author;
    double price;

    // Default constructor
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Display method
    public void displayBook() {
        System.out.println("Title: " + title + " | Author: " + author + " | Price: $" + price);
    }

    public static void main(String[] args) {
        // Create book1 using default constructor
        Book book1 = new Book();

        // Create book2 using parameterized constructor
        Book book2 = new Book("The Java Handbook", "James Gosling", 45.99);

        // Display both books
        book1.displayBook();
        book2.displayBook();
    }
}
