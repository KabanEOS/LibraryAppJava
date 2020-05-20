package Main;

import java.sql.SQLOutput;
import java.util.Scanner;

import library.Book;
import library.Library;
import org.w3c.dom.ls.LSOutput;

public class Main {

    static Library lib = new Library();
    static Scanner scan = new Scanner(System.in);
    static Boolean running = true;

    public static void main(String[] args){
        while(running){
            System.out.println(
                    "1. Register a book\n" +
                    "2. Check the availability of a book\n" +
                    "3. Rent a book\n" +
                    "4. Return a book\n" +
                    "5. List all books\n" +
                    "6. Register a user\n" +
                    "7. Show all users\n" +
                    "8. Exit");
            int answer = scan.nextInt();
            switch (answer){
                case 1: //1. Register a book
                    break;
                //FIXME


                case 2: //2. Check the availability of a book
                    System.out.println("1. Search by title \n2. Search by ISBN");
                    int answerSearch = scan.nextInt();
                    switch (answerSearch){
                        case 1:
                            System.out.println("Write title:");
                            String title = scan.next();
                            Book book = lib.getBookByTitle(title);
                            if(book != null){
                                System.out.println("Lucky You, this book is available!\n"+ book);
                            }else {
                                System.out.println("Keep trying my dear");
                            }
                        case 2:
                            System.out.println("Write ISBN:");
                            long isbn = scan.nextLong();
                            book = lib.getBookByISBN(isbn);
                            if(book != null){
                                System.out.println("Lucky You, this book is available!\n"+ book);
                            }else {
                                System.out.println("Keep trying my dear");
                            }
                            break;
                    }


                case 3: //3. Rent a book
                    break;
                //FIXME


                case 4: //4. Return a book
                    break;
                //FIXME


                case 5: //5. List all books
                    break;
                //FIXME


                case 6: //6. Register a user
                    break;
                //FIXME


                case 7: //7. Show all users
                    break;
                //FIXME


                case 8: //8. Exit
                    running = false;
                    break;
            }
        }
    }
}
