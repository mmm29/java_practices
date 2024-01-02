import java.util.HashMap;
import java.util.Map;

public class BookCache {
    private Map<Integer, Book> cache = new HashMap<>();

    public Book getBook(int id) {
        Book book = cache.get(id);
        return (Book) book.clone();
    }

    public void initialize() {
        cache.put(0, new FantasyBook());
        cache.put(1, new ScienceFictionBook());
        cache.put(2, new HorrorBook());
    }
}
