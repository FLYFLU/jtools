package com.yyou.tools.entity;

import java.io.Serializable;

public class IDjRelation implements Serializable {
    private long id;
    private long idjId;
    private long sysId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdjId() {
        return idjId;
    }

    public void setIdjId(long idjId) {
        this.idjId = idjId;
    }

    public long getSysId() {
        return sysId;
    }

    public void setSysId(long sysId) {
        this.sysId = sysId;
    }
}
