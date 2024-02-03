package com.pojo;
public class LoginPojo {
    private String username;
    private String password;

    public LoginPojo(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString() {
        return "LoginPojo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
