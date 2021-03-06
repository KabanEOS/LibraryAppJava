package library;

public class ListUserLinked {

    private NodeUser first;
    private int size;

    public ListUserLinked() {
        first = null;
        int size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public User recover(int index) {
        NodeUser aux = first;
        for (int k = 0; k < index; k++)
            aux = aux.next;
        return aux.user;
    }

    void remove(int i) {
        if (this.recover(i) == null) return;
        else {
            NodeUser last = this.first;

            for (int j = 0; j < i - 1; j++) {
                last = last.next;
            }

            last.next = last.next.next;

            this.size--;
        }
    }

    public void append(User User) {
        if (this.first == null)
            this.first = new NodeUser(User);
        else {
            NodeUser last = this.first;

            while (last.next != null) {
                last = last.next;
            }
            last.next = new NodeUser(User);
        }
        this.size++;
    }

    public User[] asArray() {
        NodeUser last = this.first;
        User arrUser[] = new User[size];
        for (int i = 0; i < this.size(); i++) {
            arrUser[i] = recover(i);
        }
        return arrUser;
    }


}
