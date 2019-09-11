package service.impl;

import bean.MessageContant;
import bean.User;
import service.inter.MenuServiceInter;
import service.inter.UserServiceInter;

import java.util.Scanner;

public class MenuServiceImpl implements MenuServiceInter {

    protected MenuServiceImpl(){

    }

    private UserServiceInter userService = DI.getUserService();

    @Override
    public int showMenu() {
        Scanner scanner = new Scanner(System.in);
        User loggedUser = userService.getLoggedInUser();
        if(loggedUser!=null){
            if(loggedUser.isAdmin()){
                System.out.println(MessageContant.menuDescriptionAfterLoginAdmin);
            }else{
                System.out.println(MessageContant.menuDescriptionAfterLoginUser);
            }
        }else{
            System.out.println(MessageContant.menuDescriptionBeforeLogin);
        }

        System.out.print("Your choice: ");
        int selectedMenu = scanner.nextInt();
        return selectedMenu;
    }
}
