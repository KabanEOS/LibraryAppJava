package library;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.io.*;

public class Library {
     private ListBookLinked books = new ListBookLinked();
     private ListUserLinked users = new ListUserLinked();


     public Library(){

          BufferedReader br = null;
          FileReader fr;
          try {
               br = new BufferedReader(new FileReader("books.txt"));                      //reads txt file and change it to string
               for(String line; (line = br.readLine()) != null; ) {                               //execute for each line
                    List<String> row = Arrays.asList(line.split("\\s*,\\s*"));              //add values to list
//                    System.out.println(row);

                    String title = row.get(0);
                    String isbnS = row.get(1);
                    String author = row.get(2);
                    String genreS = row.get(3);
                    String userDNI = row.get(4);

                    Enum Genre = Enum.valueOf(Genre.class, genreS);
                    long isbn = Long.parseLong(isbnS);

                    Book book = new Book(isbn, title, author, userDNI, (library.Genre) Genre);
                    NodeBook nodeBook = new NodeBook(book);
                    this.books.add(nodeBook);
//                    System.out.println(this.books.recover(0));
               }
          } catch (FileNotFoundException e) {
               e.printStackTrace();
          } catch (IOException e) {
               e.printStackTrace();
          }


          try {
               br = new BufferedReader(new FileReader("users.txt"));                      //reads txt file and change it to string
               for(String line; (line = br.readLine()) != null; ) {                               //execute for each line
                    List<String> row = Arrays.asList(line.split("\\s*,\\s*"));              //add values to list
//                    System.out.println(row);

                    String name = row.get(0);
                    String dni = row.get(1);
                    String email = row.get(2);
                    String currentBookS = row.get(3);

                    long currentBook = Long.parseLong(currentBookS);

                    User user = new User(name, dni, email, currentBook);
                    NodeUser nodeUser = new NodeUser(user);
                    this.users.add(nodeUser);
               }
          } catch (FileNotFoundException e) {
               e.printStackTrace();
          } catch (IOException e) {
               e.printStackTrace();
          }

     }

     public Book getBookByTitle(String title){
          for (NodeBook nodeBook: books) {
               if(nodeBook.book.getTitle().equals(title)){
                    return nodeBook.book;
               }
          }
          return null;
     }
     public Book getBookByISBN(long isbn){
          for (NodeBook nodeBook: books) {
               if(nodeBook.book.getIsbn()==(isbn)){
                    return nodeBook.book;
               }
          }
          return null;
     }
}
