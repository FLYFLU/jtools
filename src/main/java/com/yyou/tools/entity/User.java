package com.yyou.tools.entity;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private long id;
    private String name;
    private String password;
    private String description;

    public User(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public User() {
        super();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }
}
