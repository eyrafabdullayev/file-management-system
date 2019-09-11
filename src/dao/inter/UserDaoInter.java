package dao.inter;

import bean.User;
import dao.impl.UserDaoImpl;

import java.util.List;

public interface UserDaoInter {
    boolean add(User u);

    boolean save(User u);

    List<User> getAllUsers(); //must print all users

    List<User> getAllActiveUsers();

    List<User> getAllInActiveUsers();

    static UserDaoInter instance(){
        return new UserDaoImpl();
    }
}
