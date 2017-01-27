package com.ilya.shusterman.beans;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.annotation.Id;

/**
 * Created by ilya on 26/01/2017.
 */
@JsonComponent
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
