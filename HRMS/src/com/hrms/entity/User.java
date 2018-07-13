package com.hrms.entity;

import java.util.Date;

public class User {
    public User(Integer id, String name, String password, String description, Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.description = description;
        this.date = date;
    }

    private Integer id;
    private String name;
    private String password;
    private String description;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
