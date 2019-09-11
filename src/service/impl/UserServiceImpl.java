package service.impl;

import bean.User;
import config.Initializer;
import dao.inter.UserDaoInter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl extends AbstractUserService{

    public UserServiceImpl(){

    }

    private UserDaoInter userDao = UserDaoInter.instance();

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public List<User> getAllActiveUsers() {
        return userDao.getAllActiveUsers();
    }

    @Override
    public List<User> getAllInActiveUsers() {
        return userDao.getAllInActiveUsers();
    }

    @Override
    public User getLoggedInUser() {
        return Initializer.config.getLoggedInUser();
    }

    @Override
    public boolean register() {
        User user = askAllFieldsToClient();
        List<String> nonAccessFileOrFolderNameList = new ArrayList<>();
        nonAccessFileOrFolderNameList.add("C:\\");

        user.setNonAccessibleFilesOrFolders(nonAccessFileOrFolderNameList);
        return userDao.add(user);
    }

    @Override
    public User askAllFieldsToClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please insert your name: ");
        String name = scanner.nextLine();
        System.out.print("Please insert your surname: ");
        String surname = scanner.nextLine();
        System.out.print("Please insert your username: ");
        String username = scanner.nextLine();
        System.out.print("Please insert your password: ");
        String password = scanner.nextLine();
        User user = new User(name,surname,username,password);
        System.out.println("Please wait admin's accept! Thank you!");
        return user;
    }

    @Override
    public User askUsernameAndPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please insert your username: ");
        String username = scanner.nextLine();
        System.out.print("Please insert your password: ");
        String password = scanner.nextLine();
        User user = new User(username,password);
        return user;
    }

    @Override
    public boolean approveUser() {
        printAllInActiveUsers();
        if(getAllInActiveUsers().size()!=0){
            String id = askForUserById();
            User user = getUserById(id);
            user.setStatus(1);
            return userDao.save(user);
        }
        return false;
    }

}
