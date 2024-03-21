import java.util.ArrayList;

public class Member {
    public String name;
    public ArrayList<Book> borrowedBooks = new ArrayList<Book>();

    Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<Book>();
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            borrowedBooks.add(book);
            System.out.println(name + " has borrowed the book: " + book.getTitle());
        } else {
            System.out.println("Sorry, the book " + book.getTitle() + " is not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println(name + " has returned the book: " + book.getTitle());
        } else {
            System.out.println(name + " did not borrow the book: " + book.getTitle());
        }
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has not borrowed any books.");
        } else {
            System.out.println(name + "'s Borrowed Books:");
            for (Book book : borrowedBooks) {
                book.displayInfo();
                System.out.println("");
            }
        }
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getName() {
        return name;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Member member1 = new Member("Auvar Mahsa Fahlevi");
        Library library = new Library();
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951, true);
        library.addBook(book1);
        member1.borrowBook(book1);
        member1.displayBorrowedBooks();
        member1.returnBook(book1);
        member1.displayBorrowedBooks();
    }
}
