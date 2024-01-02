public class FantasyBook extends Book {
    FantasyBook() {
        super("fantasy");
    }

    @Override
    public void printContent() {
        System.out.printf("%s:%s,%dpp.%n", this.getISBN(), this.getGenre(), this.getPagesCount());
    }
}
