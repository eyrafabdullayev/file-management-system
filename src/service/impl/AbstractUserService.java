package service.impl;

import bean.MessageContant;
import bean.User;
import config.Initializer;
import service.inter.UserServiceInter;

import java.util.List;
import java.util.Scanner;

public abstract class AbstractUserService implements UserServiceInter {

    @Override
    public void printAllUser() {
       List<User> allUsers = getAllUsers();
       if(allUsers!= null && allUsers.size()>1){
           for(User u:allUsers){
               if(!"admin".equals(u.getUsername())){
                   System.out.println(u);
               }
           }
       }else{
           System.out.println("User not found!");
       }
    }

    @Override
    public void printAllActiveUsers() {
       List<User> allActiveUsers = getAllActiveUsers();
        if(allActiveUsers != null && allActiveUsers.size()>1){
            for(User u:allActiveUsers){
                if(!"admin".equals(u.getUsername()) && u.getStatus()==1){
                    System.out.println(u);
                }
            }
        }else{
            System.out.println("User not found!");
        }
    }

    @Override
    public void printAllInActiveUsers() {
       List<User> allInActiveUsers = getAllInActiveUsers();
        if(allInActiveUsers!=null && allInActiveUsers.size()!=0){
            for(User u:allInActiveUsers){
                if(!"admin".equals(u.getUsername()) && u.getStatus()!=1){
                    System.out.println(u);
                }
            }
        }else{
            System.out.println("User not found!");
        }
    }

    @Override
    public void printMySelf() {
       User user = getLoggedInUser();
       System.out.println(user);
    }

    @Override
    public String askForUserById() {
        System.out.println(MessageContant.whichUserToApprove);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public User login() {
        User enteredUser = askUsernameAndPassword();
        List<User> acticeUsers = getAllActiveUsers();
        for(User u:acticeUsers){
            if(u.getUsername().equals(enteredUser.getUsername()) && u.getPassword().equals(enteredUser.getPassword())){
                Initializer.config.setLoggedInUser(u);
                return u;
            }
        }

        throw new IllegalArgumentException("Invalid username or password!");
    }

    @Override
    public User getUserById(String id) {
        List<User> list = getAllUsers();
        if(list==null && list.size()==0){
            return null;
        }
        System.out.println("id="+id);
        for(User u:list){
            if(u.getId() != null){
                if(u.getId().equals(id)){
                    return u;
                }
            }
        }

        return list.get(1);
    }
}
