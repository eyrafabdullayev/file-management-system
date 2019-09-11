package bean;

import java.io.Serializable;
import java.util.List;

public class Config implements Serializable {
    private transient User loggedInUser;
    private List<User> allUsers;
    public static final String pathname = "fmconfig.ser";

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }
}
