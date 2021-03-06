package library;

public class Book {

    private long isbn;
    private String title, author, userDNI;
    private  Genre genre;

    public Book() {
        isbn = 0;
        title = null;
        author = null;
        genre = Genre.NONE;
        userDNI = null;
    }

    public Book(long isbn, String title, String author, Enum genre, String userDNI){
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.genre = (Genre) genre;
            this.userDNI = userDNI;
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

        @Override
        public String toString() {
            return title+","+isbn+","+author +","+ genre +","+userDNI+"\n";
        }
    }
