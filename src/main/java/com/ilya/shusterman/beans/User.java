package com.ilya.shusterman.beans;

import org.springframework.data.annotation.Id;

/**
 * Created by ilya on 26/01/2017.
 */
public class User {

    @Id
    public String id;
    public String type;
    public String userName;
    public String password;

    public User(){
    }
    public User(String userName, String password,String type) {
        this.type = type;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

}
