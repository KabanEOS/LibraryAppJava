package library;

public class Book {

    private long isbn;
    private String title, author, userDNI;
    private  Genre genre;

        public Book() {

            isbn = 0;
            title = null;
            author = null;
            userDNI = null;
            genre = Genre.NONE;
        }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUserDNI() {
        return userDNI;
    }

    public void setUserDNI(String userDNI) {
        this.userDNI = userDNI;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Book(long isbn, String title, String author, String userDNI, Genre genre){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.userDNI = userDNI;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return title+","+isbn+","+author+","+userDNI +","+ genre +"\n";
    }
}

