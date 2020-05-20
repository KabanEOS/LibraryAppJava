package library;

public class User {

    private String name, dni, email;
    private long currentBook;

    public User() {
        name = null;
        dni = null;
        email = null;
        currentBook = -1;
    }

    public User(String name, String dni, String email, long currentBook) {
        this.currentBook = currentBook;
        this.name = name;
        this.dni = dni;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCurrentBook() {
        return currentBook;
    }

    public void setCurrentBook(long currentBook) {
        this.currentBook = currentBook;
    }


    @Override
    public String toString(){
        return name+","+dni+","+email+","+currentBook;
    }

// FIXME!!! @Override equals "just compare DNI member"

}
