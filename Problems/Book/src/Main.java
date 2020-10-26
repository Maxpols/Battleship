import java.util.Arrays;

class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;
    int authorsLength = authors.length;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public int getYearOfPublishing() {
        return yearOfPublishing;
    }
    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    String[] authorsCopy;

    public String[] getAuthors() {
        return authorsCopy = Arrays.copyOf(authors, authorsLength);
    }
    public void setAuthors(String[] authors) {
        this.authors = authorsCopy;
    }
}