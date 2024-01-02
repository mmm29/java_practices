import java.util.Iterator;
import java.util.LinkedList;

public class BookShelf {
    private static BookShelf INSTANCE = new BookShelf();

    private LinkedList<Book> books = new LinkedList<>();

    private BookShelf() {

    }

    public static BookShelf getInstance() {
        return INSTANCE;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public boolean removeBook(int ISBN) {
        Iterator<Book> iterator = this.books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getISBN() == ISBN) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public void printContent() {
        System.out.println("Books in the book shelf:");
        for (Book book : this.books) {
            book.printContent();
        }
    }
}
