package Main;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

import library.Book;
import library.Genre;
import library.Library;
import library.ListBookLinked;
import org.w3c.dom.ls.LSOutput;

public class Main {

    static Library lib = new Library();
    static Scanner scan = new Scanner(System.in);
    static Boolean running = true;


    public static void main(String[] args) throws IOException {


        while (running) {
            System.out.println(
                    // Michał Madejski !!!
                    "1. Register a book\n" +
                            "2. Check the availability of a book\n" +
                            "3. Rent a book\n" +
                            "4. Return a book\n" +
                            "5. List all books\n" +
                            "6. Register a user\n" +
                            "7. Show all users\n" +
                            "8. Exit");
            int answer = scan.nextInt();
            switch (answer) {
                case 1: //1. Register a book
                    System.out.println("Registering a new book. \nWrite title:");
                    scan.nextLine();
                    String userDataInputBook = "";
                    userDataInputBook = scan.nextLine();
                    System.out.println("Write ISBN number:");
                    long checkISBN = scan.nextLong();
                    if (lib.checkISBN(checkISBN) == false) {
                        userDataInputBook = userDataInputBook.concat("," + checkISBN);
                    } else {
                        System.out.println("This book has been already registered");
                        break;
                    }
                    System.out.println("Write author:");
                    scan.nextLine();
                    userDataInputBook = userDataInputBook.concat("," + scan.nextLine());
                    System.out.println("Chose genre by writing a number:");
                    System.out.println("1.NONE\n 2.ADVENTURE\n 3.CRIME\n 4.K_DRAMA\n 5.FANTASY\n 6.HORROR\n 7.MYSTERY\n 8.POETRY\n 9.THRILLER\n 10.BIOGRAPHY\n 11.JOURNAL\n 12.SCIENCE\n 13.TRAVEL");
                    int genre = scan.nextInt();
                    switch (genre) {
                        case 1:
                            userDataInputBook = userDataInputBook.concat(",NONE");
                            break;
                        case 2:
                            userDataInputBook = userDataInputBook.concat(",ADVENTURE");
                            break;
                        case 3:
                            userDataInputBook = userDataInputBook.concat(",CRIME");
                            break;
                        case 4:
                            userDataInputBook = userDataInputBook.concat(",K_DRAMA");
                            break;
                        case 5:
                            userDataInputBook = userDataInputBook.concat(",FANTASY");
                            break;
                        case 6:
                            userDataInputBook = userDataInputBook.concat(",HORROR");
                            break;
                        case 7:
                            userDataInputBook = userDataInputBook.concat(",MYSTERY");
                            break;
                        case 8:
                            userDataInputBook = userDataInputBook.concat(",POETRY");
                            break;
                        case 9:
                            userDataInputBook = userDataInputBook.concat(",THRILLER");
                            break;
                        case 10:
                            userDataInputBook = userDataInputBook.concat(",BIOGRAPHY");
                            break;
                        case 11:
                            userDataInputBook = userDataInputBook.concat(",JOURNAL");
                            break;
                        case 12:
                            userDataInputBook = userDataInputBook.concat(",SCIENCE");
                            break;
                        case 13:
                            userDataInputBook = userDataInputBook.concat(",TRAVEL");
                            break;
                    }

                    userDataInputBook = userDataInputBook.concat("," + "null");
                    lib.addNewBook(userDataInputBook);

                    System.out.println("You have succesfully registered a book");
                    break;


                case 2: //2. Check the availability of a book
                    System.out.println("1. Search by title \n2. Search by ISBN");
                    int answerSearch = scan.nextInt();
                    switch (answerSearch) {
                        case 1:
                            System.out.println("Write title:\t");
                            Book book = new Book();
                            scan.nextLine();
                            String title = "";
                            title = scan.nextLine();
                            book = lib.getBookByTitle(title);
                            if (book != null) {
                                System.out.println("Lucky You, this book is available!\n" + book);
                                break;
                            } else {
                                System.out.println("Keep trying my dear");
                                break;
                            }
                        case 2:
                            System.out.println("Write ISBN:");
                            long isbn = scan.nextLong();
                            book = lib.getBookByISBN(isbn);
                            if (book != null) {
                                System.out.println("Lucky You, this book is available!\n" +book.getTitle()+", "+book.getGenre()+", "+book.getIsbn());
                                break;
                            } else {
                                System.out.println("Keep trying my dear");
                                break;
                            }
                    }
                break;

                case 3: //3. Rent a book
                    System.out.println("Renting a book\nInsert your DNI:");
                    scan.nextLine();
                    String userDNI = scan.nextLine();
                    System.out.println("Insert title of requested book:");
                    String titleBookToRent = scan.nextLine();
                    if (lib.rentBook(userDNI, titleBookToRent)) {
                        System.out.println("You have sucesfully rented book " + titleBookToRent);
                        break;
                    } else {
                        System.out.println("You can not rent a book");
                        break;
                    }

                case 4: //4. Return a book
                    System.out.println("Returning a book\nInsert title:");
                    scan.nextLine();
                    String titleBookToReturn = scan.nextLine();

                    if (lib.returnBook(titleBookToReturn)) {
                        System.out.println("You have sucesfully returned book " + titleBookToReturn);
                        break;
                    } else {
                        System.out.println("You can not return this book");
                        break;
                    }

                case 5: //5. List all books
                    lib.listAllBooks();
                    break;

                case 6: //6. Register a user
                    System.out.println("Registering a new user. \nWrite name and surname:");
                    scan.nextLine();
                    String userDataInputUser = "";
                    userDataInputUser = scan.nextLine();
                    System.out.println("Write DNI number:");
                    String checkDNI = scan.nextLine();
                    if (lib.checkDNI(checkDNI) == false) {
                        userDataInputUser = userDataInputUser.concat("," + checkDNI);
                    } else {
                        System.out.println("This user has been already registered");
                        break;
                    }
                    System.out.println("Write email:");
                    userDataInputUser = userDataInputUser.concat("," + scan.nextLine());
                    userDataInputUser = userDataInputUser.concat("," + "-1");
                    System.out.println("You have sucesfully registered a user.");

                    lib.addNewUser(userDataInputUser);
                    break;

                case 7: //7. Show all users
                    lib.listAllUsers();
                    break;

                case 8: //8. Exit
                    running = false;
                    break;
            }
        }
    }
}

