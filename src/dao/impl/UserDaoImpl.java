package dao.impl;

import bean.User;
import config.Initializer;
import dao.inter.UserDaoInter;
import service.inter.FileManagerServiceInter;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDaoInter {

    @Override
    public boolean add(User u) {
        List<User> list = getAllUsers();
        list.add(u);
        Initializer.refreshConfig();
        return true;
    }

    @Override
    public boolean save(User u) {
        Initializer.refreshConfig();
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return Initializer.config.getAllUsers();
    }

    @Override
    public List<User> getAllActiveUsers() {
        List<User> allUsers = getAllUsers();

        List<User> allAciveUsers = new ArrayList<>();
        for(User u:allUsers){
            if(u.getStatus() == 1){
                allAciveUsers.add(u);
            }
        }

        return allAciveUsers;
    }

    @Override
    public List<User> getAllInActiveUsers() {
        List<User> allUsers = getAllUsers();

        List<User> allInActiveUsers = new ArrayList<>();
        for(User u:allUsers){
            if(u.getStatus() != 1){
                allInActiveUsers.add(u);
            }
        }

        return allInActiveUsers;
    }
}
