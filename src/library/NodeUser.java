package library;

public class NodeUser {
    public User user;
    NodeUser next;

    public NodeUser(User user)
    {
        this.user = user;
        next = null;
    }

}
