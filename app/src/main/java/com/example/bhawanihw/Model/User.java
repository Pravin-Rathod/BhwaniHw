package com.example.bhawanihw.Model;

public class User {

    private int id;

    public User(int id, String username, String email, String mobileno) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.mobileno = mobileno;
    }

    private String username, email, mobileno;

    public int getId(){
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileno() {
        return mobileno;
    }
}
