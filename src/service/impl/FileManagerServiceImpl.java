package service.impl;

import bean.Config;
import bean.MessageContant;
import bean.User;
import service.inter.FileManagerServiceInter;
import service.inter.UserServiceInter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FileManagerServiceImpl implements FileManagerServiceInter {

    protected FileManagerServiceImpl(){
    }

    private UserServiceInter userService = DI.getUserService();

    @Override
    public String getSelectedFolderOrFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please insert file or folder name: ");
        String fileOrFolderName = scanner.nextLine();
        return fileOrFolderName;
    }

    @Override
    public boolean checkUserAccessToFile(String fileOrFolderPath) {
        User user = userService.getLoggedInUser();
        List<String> userAccessFileOrFolderName = user.getNonAccessibleFilesOrFolders();

        boolean hasAccess = !userAccessFileOrFolderName.contains(fileOrFolderPath);
        return hasAccess;
    }

    @Override
    public void printAllSubFilesAndFolders() {
        String fileOrFolderName = getSelectedFolderOrFilePath();
        boolean hasAccess = checkUserAccessToFile(fileOrFolderName);

        File folder = new File(fileOrFolderName);
        if(isItFolder(fileOrFolderName) && hasAccess){
            File[] listOfFiles = folder.listFiles();

            for(int i=0;i<listOfFiles.length;i++){
                if(listOfFiles[i].isDirectory()){
                    System.out.println("Directory="+listOfFiles[i].getName());
                }else if(listOfFiles[i].isFile()){
                    System.out.println("File="+listOfFiles[i].getName());
                }
            }
        }else{
            System.out.println(MessageContant.hasNotAccess);
        }
    }


    @Override
    public boolean isItFolder(String pathname){
        Path path = new File(pathname).toPath();
        boolean isDirectory = Files.isDirectory(path);
        return isDirectory;
    }

    @Override
    public void exit() {
       System.out.println("Exiting the program...");
       System.exit(0);
    }

    @Override
    public Config readConfig() {
        return (Config) util.ReadFileIO.readFileDeserialize(Config.pathname);
    }
}
