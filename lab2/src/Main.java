//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BookShelf shelf = BookShelf.getInstance();
        BookGenerator generator = new BookGenerator();

        BookCache cache = new BookCache();
        cache.initialize();

        for (int i = 0; i < 10; i++) {
            shelf.addBook(generator.generate(cache));
        }

        shelf.printContent();
    }
}