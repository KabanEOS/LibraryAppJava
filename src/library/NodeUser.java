package library;


public class NodeUser<User> {
    User user;
    NodeUser next;

    public NodeUser(User user)
    {
        this.user = user;
        next = null;
    }

}
