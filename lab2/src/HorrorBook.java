public class HorrorBook extends Book {
    HorrorBook() {
        super("horror");
    }

    @Override
    public void printContent() {
        System.out.printf("%s:%s,%dpp.%n", this.getISBN(), this.getGenre(), this.getPagesCount());
    }
}
