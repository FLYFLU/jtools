package com.yyou.tools.entity.operation;

import java.io.Serializable;

public class AutoIncreaseId implements Serializable {
    private int id;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AutoIncreaseId{" +
                "id=" + id +
                ", remark='" + remark + '\'' +
                '}';
    }
}
