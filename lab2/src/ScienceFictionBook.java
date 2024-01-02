public class ScienceFictionBook extends Book {
    ScienceFictionBook() {
        super("science fiction");
    }

    @Override
    public void printContent() {
        System.out.printf("%s:%s,%dpp.%n", this.getISBN(), this.getGenre(), this.getPagesCount());
    }
}
