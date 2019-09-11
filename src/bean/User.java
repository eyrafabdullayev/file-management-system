package bean;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class User implements Serializable {
    private String id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private int status;
    private int position;
    private List<String> nonAccessibleFilesOrFolders;

    public User(String username,String password){
       this.username = username;
       this.password = password;
    }

    public User(String name,String surname,String username,String password){
        this.id = UUID.randomUUID().toString();
       this.name = name;
       this.surname = surname;
       this.username = username;
       this.password = password;
    }

    public User(String name,String surname,String username,String password,List<String> nonAccessibleFilesOrFolders){
       this.name = name;
       this.surname = surname;
       this.username = username;
       this.password = password;
       this.nonAccessibleFilesOrFolders = nonAccessibleFilesOrFolders;
    }

    public boolean isAdmin(){
        return position == 1; //true or false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<String> getNonAccessibleFilesOrFolders() {
        return nonAccessibleFilesOrFolders;
    }

    public void setNonAccessibleFilesOrFolders(List<String> nonAccessibleFilesOrFolders) {
        this.nonAccessibleFilesOrFolders = nonAccessibleFilesOrFolders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", position=" + position +
                ", nonAccessibleFilesOrFolders=" + nonAccessibleFilesOrFolders +
                '}';
    }
}
