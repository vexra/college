import java.util.ArrayList;

public class Library {
    public ArrayList<Book> books = new ArrayList<Book>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books in the Library:");

        for (int i = 0, e = books.size(); i < e; ++i) {
            Book tmp = books.get(i);

            if (tmp.available) {
                tmp.displayInfo();
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, true);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960, true);
        Book book3 = new Book("1984", "George Orwell", 1949, true);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.displayAvailableBooks();
    }
}
