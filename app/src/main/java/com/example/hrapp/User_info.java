package com.example.hrapp;

public class User_info {


    String username,email,password,location1,location2;

    public User_info() {

    }

    public User_info(String username, String email, String password,String location1,String location2) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.location1= location1;
        this.location2 = location2;
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation1() {
        return location1;
    }

    public void setLocation1(String location1) {
        this.location1 = location1;
    }

    public String getLocation2() {
        return location2;
    }

    public void setLocation2(String location2) {
        this.location2 = location2;
    }
}
