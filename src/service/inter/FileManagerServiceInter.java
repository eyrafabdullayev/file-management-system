package service.inter;

import bean.Config;

public interface FileManagerServiceInter {
    String getSelectedFolderOrFilePath();

    boolean checkUserAccessToFile(String fileOrFolderPath);

    void printAllSubFilesAndFolders();

    boolean isItFolder(String path);

    void exit();

    Config readConfig();
}
