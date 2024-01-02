public abstract class Book implements Cloneable {
    private int ISBN;
    private int pagesCount;
    private String genre;

    protected Book(String genre) {
        this.genre = genre;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public String getGenre() {
        return genre;
    }

    public abstract void printContent();

    @Override
    public Object clone() {
        Object obj = null;

        try {
            obj = super.clone();
        }
        catch (CloneNotSupportedException e) {

        }

        return obj;
    }
}
