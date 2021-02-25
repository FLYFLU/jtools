package com.yyou.tools.dto.rx.table;

public class SubColumPrefixInput {
    /**
     * 表名
     */
    private String tableName;
    /**
     * 列名
     */
    private String columnName;

    /**
     * 前缀
     */
    private String prefix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
