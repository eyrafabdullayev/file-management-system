package config;

import bean.Config;
import bean.User;
import service.impl.DI;
import service.inter.FileManagerServiceInter;
import util.WriteFileIO;

import java.util.ArrayList;
import java.util.List;

public class Initializer {
    public static Config config;

    private static FileManagerServiceInter fms = DI.getFileManagerService();

    public static void initialize(){
       config = fms.readConfig();
       if(config==null){
           User user = new User("admin","admin");
           user.setStatus(1);
           user.setPosition(1);
           List<User> list = new ArrayList<>();
           list.add(user);
           config = new Config();
           config.setAllUsers(list);
           Initializer.refreshConfig();
           initialize();
       }
    }

    public static void refreshConfig(){
        WriteFileIO.writeObjectToFile(config,Config.pathname);
    }
}
