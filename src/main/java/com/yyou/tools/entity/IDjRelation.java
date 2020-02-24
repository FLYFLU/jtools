package com.yyou.tools.entity;

import java.io.Serializable;

public class IDjRelation implements Serializable {
    private int id;
    private int idjId;
    private String sysId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdjId() {
        return idjId;
    }

    public void setIdjId(int idjId) {
        this.idjId = idjId;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }
}
