public class Main {
    public static void main(String[] args) {
        Member member1 = new Member("Auvar Mahsa Fahlevi");
        Member member2 = new Member("Muhammad Fadhilah");
        Library library = new Library();
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951, true);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960, true);
        Book book3 = new Book("1984", "George Orwell", 1949, true);
        Book book4 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, true);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        member1.borrowBook(book1);
        member1.borrowBook(book2);
        member2.borrowBook(book2);
        member2.borrowBook(book3);
        library.displayAvailableBooks();
        member1.displayBorrowedBooks();
        member2.displayBorrowedBooks();
        member1.returnBook(book1);
        library.displayAvailableBooks();
    }
}
