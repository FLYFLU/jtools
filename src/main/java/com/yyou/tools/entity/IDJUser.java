package com.yyou.tools.entity;

import java.io.Serializable;

public class IDJUser implements Serializable {
    private String idcard;
    private int id;
    private String password;
    private String username;
    private IDjRelation user;

    public IDjRelation getUser() {
        return user;
    }

    public void setUser(IDjRelation user) {
        this.user = user;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
