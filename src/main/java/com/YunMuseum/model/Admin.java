package com.YunMuseum.model;

public class Admin {
    private String adminname;

    private String password;

    private String salt;

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String admin_name) {
        this.adminname = admin_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt(){
        return salt;
    }

    public void setSalt(String salt){
        this.salt = salt;
    }
}