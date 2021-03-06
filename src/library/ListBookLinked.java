package library;

public class ListBookLinked {

    private NodeBook first;
    private int size;

    public ListBookLinked() {
        first = null;
        int size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Book recover(int index) {
        NodeBook aux = first;
        for (int k = 0; k < index; k++)
            aux = aux.next;
        return aux.book;
    }

    void remove(int i) {
        if (this.recover(i) == null) return;
        else {
            NodeBook last = this.first;

            for (int j = 0; j < i - 1; j++) {
                last = last.next;
            }

            last.next = last.next.next;

            this.size--;
        }
    }

    public void append(Book book) {
        if (this.first == null)
            this.first = new NodeBook(book);
        else {
            NodeBook last = this.first;

            while (last.next != null) {
                last = last.next;
            }
            last.next = new NodeBook(book);
        }
        this.size++;
    }

    public void insert(int i, Book book) {
        NodeBook last = this.first;
        for(int j = 0; j < i - 1; j++) {
            last = last.next;
        }

        NodeBook memo = last.next;

        NodeBook nodeBook = new NodeBook(book);
        nodeBook.next = memo;

        last.next = nodeBook;
    }

    public Book[] asArray() {
        NodeBook last = this.first;
        Book arrBook[] = new Book[size];
        for (int i = 0; i < this.size(); i++) {
            arrBook[i] = recover(i);
        }
        return arrBook;
    }


}
