package library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.io.*;


public class Library {
    private ListBookLinked books = new ListBookLinked();
    private ListUserLinked users = new ListUserLinked();

    public Library() {

        BufferedReader br = null;
        FileReader fr;
        try {
            br = new BufferedReader(new FileReader("books.txt"));                      //reads txt file and change it to string
            for (String line; (line = br.readLine()) != null; ) {                               //execute for each line
                List<String> row = Arrays.asList(line.split("\\s*,\\s*"));              //add values to list

                String title = row.get(0);
                String isbnS = row.get(1);
                String author = row.get(2);
                String genreS = row.get(3);
                String userDNI = row.get(4);

                Enum Genre = Enum.valueOf(Genre.class, genreS);
                long isbn = Long.parseLong(isbnS);

                Book book = new Book(isbn,
                        title,
                        author,
                        (library.Genre) Genre,
                        userDNI);
                this.books.append(book);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            br = new BufferedReader(new FileReader("users.txt"));                      //reads txt file and change it to string
            for (String line; (line = br.readLine()) != null; ) {                               //execute for each line
                List<String> row = Arrays.asList(line.split("\\s*,\\s*"));              //add values to list

                String name = row.get(0);
                String dni = row.get(1);
                String email = row.get(2);
                String currentBookIsbnS = row.get(3);

                long currentBookIsbn = Long.parseLong(currentBookIsbnS);

                User user = new User(name,
                        dni,
                        email,
                        currentBookIsbn);
                NodeUser nodeUser = new NodeUser(user);
                this.users.append(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addNewUser(String userDataInputUser) throws IOException {
        List<String> row = Arrays.asList(userDataInputUser.split("\\s*,\\s*"));

        String name = row.get(0);
        String dni = row.get(1);
        String email = row.get(2);
        String currentBookIsbnS = row.get(3);

        long currentBookIsbn = Long.parseLong(currentBookIsbnS);

        User user = new User(name, dni, email, currentBookIsbn);
        NodeUser nodeUser = new NodeUser(user);
        this.users.append(user);
        synchronizeUsers();
    }

    public void synchronizeUsers() throws IOException {

        FileWriter fw;
        fw = new FileWriter("users.txt");

        User[] array = new User[users.size() + 1];
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            for (User user : users.asArray()) {
                bw.write(user.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addNewBook(String userDataInputBook) throws IOException {
        List<String> row = Arrays.asList(userDataInputBook.split("\\s*,\\s*"));

        String title = row.get(0);
        String isbnS = row.get(1);
        String author = row.get(2);
        String genreS = row.get(3);
        String userDNI = row.get(4);

        Enum Genre = Enum.valueOf(Genre.class, genreS);
        long isbn = Long.parseLong(isbnS);

        Book book = new Book(isbn, title, author, Genre, userDNI);
        this.books.append(book);
        synchornizeBooks();
    }

    public void synchornizeBooks() throws IOException {

        FileWriter fw;
        fw = new FileWriter("books.txt");

        Book[] array = new Book[books.size() + 1];
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            for (Book book : books.asArray()) {
                bw.write(book.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Book getBookByISBN(long isbn) {
        for (Book nodeBook : books.asArray()) {
            if (nodeBook.getIsbn() == (isbn)) {
                return nodeBook;
            }
        }
        return null;
    }

    public Book getBookByTitle(String title) {
        for (Book nodeBook : books.asArray()) {
            if (nodeBook.getTitle().equals(title)) {
                return nodeBook;
            }
        }
        return null;
    }

    public boolean checkDNI(String checkDNI) {
        // I decided to use only DNI to make verification cause in case two people has the same name, what is possible program won't work correctly
        for (User user : users.asArray()) {
            if (user.getDni().equals(checkDNI)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkISBN(long checkISBN) {
        // I decided to use only ISBN to make verification cause in case two books has the same title, what is possible program won't work correctly
        for (Book book : books.asArray()) {
            if (book.getIsbn() == (checkISBN)) {
                return true;
            }
        }
        return false;
    }

    public void listAllBooks() {
        int n = 1;
        for (Book book : this.books.asArray()) {
            System.out.println(n + ". " + book.getTitle() + " " + book.getAuthor() + " " + book.getGenre() + " " + book.getIsbn());
            n++;
        }
        System.out.println();
    }

    public void listAllUsers() {
        int m = 1;
        for (User user : users.asArray()) {
            System.out.println(m + ". " + user.getName() + " " + user.getDni() + " " + user.getName());
            m++;
        }
        System.out.println();
    }

    public boolean rentBook(String userDNI, String title) throws IOException {
        boolean userRegistered = false;
        boolean titleAvailable = false;
        long currentBookIsbn = 0;
        Book bookToRent = null;
        User userRenting = null;
        for (User user : users.asArray()) {
            if (user.getDni().equals(userDNI)) {
                userRegistered = true;
                userRenting = user;
            }
        }
        for (Book book : books.asArray()) {
            if (book.getTitle().equals(title)) {
                titleAvailable = true;
                bookToRent = book;
                currentBookIsbn = bookToRent.getIsbn();
            }
        }

        boolean isBookRent = !bookToRent.getUserDNI().equals(null);

        boolean userHasRented = userRenting.getCurrentBook() == (-1);

        if (userRegistered && titleAvailable && isBookRent && userHasRented) {

            userRenting.setCurrentBook(currentBookIsbn);
            bookToRent.setUserDNI(userDNI);
            synchronizeUsers();
            synchornizeBooks();
            return true;
        } else
            return false;
    }

    public boolean returnBook(String title) throws IOException {
        boolean titleAvailable = false;
        boolean isBookRent = false;
        Book bookToReturn = null;
        long currentBookIsbn = 0;
        User userReturning = null;

        for (Book book : books.asArray()) {
            if (book.getTitle().equals(title)) {
                titleAvailable = true;
                bookToReturn = book;
                currentBookIsbn = bookToReturn.getIsbn(); // ?
            }
        }

        for (User user : users.asArray()) {
            if (user.getCurrentBook() == (currentBookIsbn)) {
                isBookRent = true;
                userReturning = user;
            }
        }

        if (titleAvailable && isBookRent) {
            userReturning.setCurrentBook(-1);
            bookToReturn.setUserDNI(null);
            synchronizeUsers();
            synchornizeBooks();
            return true;
        }else
            return false;
    }
}