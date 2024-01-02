import java.util.Random;

public class BookGenerator {
    public Book generate(BookCache bookCache) {
        Random rand = new Random();
        int bookId = rand.nextInt(3);
        Book book = bookCache.getBook(bookId);
        book.setISBN(rand.nextInt(10000));
        book.setPagesCount(rand.nextInt(1000));
        return book;
    }
}
