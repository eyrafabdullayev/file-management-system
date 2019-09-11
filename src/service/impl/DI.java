package service.impl;

import bean.User;
import dao.impl.UserDaoImpl;
import dao.inter.UserDaoInter;
import service.inter.FileManagerServiceInter;
import service.inter.MenuServiceInter;
import service.inter.UserServiceInter;

public class DI {
    private static UserServiceInter userService = new UserServiceImpl();
    private static MenuServiceInter menuService = new MenuServiceImpl();
    private static FileManagerServiceInter fileManagerService = new FileManagerServiceImpl();
    private static UserDaoInter userDao = new UserDaoImpl();

    public static UserServiceInter getUserService() {
        return userService;
    }

    public static MenuServiceInter getMenuService() {
        return menuService;
    }

    public static FileManagerServiceInter getFileManagerService() {
        return fileManagerService;
    }

    public static UserDaoInter getUserDao() {
        return userDao;
    }
}
