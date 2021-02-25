package com.yyou.tools.dto.rx.table;

/**
 * 修改列类型输入
 */
public class ChangeColumDefInut {
    /**
     * 表名
     */
    private String tableName;
    /**
     * 要修改的列名
     */
    private String columnName;
    /**
     * 修改后类型
     */
    private String targetTypeName;
    /**
     * 同步字段需要加上前缀
     */
    private String prefix;

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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getTargetTypeName() {
        return targetTypeName;
    }

    public void setTargetTypeName(String targetTypeName) {
        this.targetTypeName = targetTypeName;
    }
}
