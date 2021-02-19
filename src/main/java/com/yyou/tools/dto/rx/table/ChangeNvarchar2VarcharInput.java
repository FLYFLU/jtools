package com.yyou.tools.dto.rx.table;

import io.swagger.annotations.ApiModelProperty;

public class ChangeNvarchar2VarcharInput {
    /**
     * 修改的表名p
     */
    @ApiModelProperty(required = true, value = "表名")
    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
