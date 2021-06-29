package Encapsulation;

public class User {
    private int id;
    private String name;
    private String pwd;
    private boolean admin;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public boolean isAdmin(){
        return admin;
    }

    public void setAdmin(boolean admin){
        this.admin = admin;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPwd(){
        return pwd;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }

    public static void main(String[] args) {
        
    }
}