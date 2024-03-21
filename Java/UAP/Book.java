public class Book {
    public String title;
    public String author;
    public int publicationYear; 
    public boolean available = true;

    Book(String title, String author, int publicationYear, boolean available) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = available;
    }

    public void displayInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Publication Year: " + this.publicationYear);
        System.out.println("Available: " + this.available);
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static void main (String args[]) {
        Book book = new Book("Harry Potter", "JK. Rowling", 2002, true);
        book.displayInfo();
    }
}