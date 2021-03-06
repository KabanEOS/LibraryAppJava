package library;

public class NodeBook {
    public Book book;
    NodeBook next;

    public NodeBook(Book book)
    {
        this.book = book;
        next = null;
    }

}
