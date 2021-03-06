package com.ystu.web_first.Model;

public class Person {
    private long id;
    private String name;
    private String pass;
    private String email;


    public Person(long id, String name, String pass, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
