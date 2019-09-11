import config.Initializer;
import service.impl.DI;
import service.inter.FileManagerServiceInter;
import service.inter.MenuServiceInter;
import service.inter.UserServiceInter;

public class Main {

    private static FileManagerServiceInter fms = DI.getFileManagerService();
    private static UserServiceInter userService = DI.getUserService();
    private static MenuServiceInter menuService = DI.getMenuService();

    public static void main(String[] args) {
        Initializer.initialize();

        while (true){
            int selectedMenu = menuService.showMenu();

            if(selectedMenu==1){
                userService.printAllUser();
            }else if(selectedMenu==2){
                userService.printAllActiveUsers();
            }else if(selectedMenu==3){
                userService.printAllInActiveUsers();
            }else if(selectedMenu==4){
                userService.approveUser();
            }else if(selectedMenu==5){
                userService.printMySelf();
            }else if(selectedMenu==6){
                fms.printAllSubFilesAndFolders();
            }else if(selectedMenu==7){
                fms.exit();
            }else if(selectedMenu==8){
                userService.register();
            }else if(selectedMenu==9){
                userService.login();
            }else{
                continue;
            }
        }

    }
}
