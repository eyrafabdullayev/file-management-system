package service.inter;

import bean.User;

import java.util.List;

public interface UserServiceInter {
    List<User> getAllUsers();

    List<User> getAllActiveUsers();

    List<User> getAllInActiveUsers();

    User getLoggedInUser();

    boolean register();

    boolean approveUser();

    void printAllUser();

    void printAllActiveUsers();

    void printAllInActiveUsers();

    void printMySelf();

    User askAllFieldsToClient();

    User askUsernameAndPassword();

    String askForUserById();

    User getUserById(String id);

    User login();
}
