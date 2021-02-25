package com.yyou.tools.dao.rx;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ITableSyncDao {

    /**
     * 获取nvarchar 列
     *
     * @param tableName 表名
     * @return 列表
     */
    @Select("SELECT T.TABLE_NAME, T.COLUMN_NAME, T.DATA_LENGTH, C.comments\n" +
            "  FROM user_tab_columns T\n" +
            "  LEFT JOIN user_col_comments C\n" +
            "    ON T.TABLE_NAME = C.table_name\n" +
            "   AND T.COLUMN_NAME = C.column_name\n" +
            " WHERE T.DATA_TYPE = 'NVARCHAR2'\n" +
            " AND T.TABLE_NAME  = #{tableName}")
    List<Map<String, Object>> getNvarcharColumns(@Param("tableName") String tableName);

    /**
     * 新增varchar2列
     *
     * @param tableName  表名
     * @param columnName 列名
     * @param length     字段长度
     * @return 更新结果
     */
    @Update("alter table ${tableName} add ${columnName}_1 VARCHAR2(${length})\n")
    int addVarcharColumn(String tableName, String columnName, String length);

    /**
     * 增加注释
     *
     * @param tableName  表名
     * @param columnName 列名
     * @param commnet    注释
     * @return 更新结果
     */
    @Update("comment on column  ${tableName}.${columnName}_1 is '${commnet}'")
    int addCommnet(String tableName, String columnName, String commnet);

    /**
     * 同步列数据
     *
     * @param tableName  表名
     * @param columnName 列名
     * @return 更新结果
     */
    @Update("UPDATE ${tableName} SET ${columnName}_1 = ${columnName}")
    int syncColumnData(String tableName, String columnName);

    /**
     * 同步列数据
     *
     * @param tableName  表名
     * @param columnName 列名
     * @param prefix     前缀
     * @return 更新结果
     */
    @Update("UPDATE ${tableName} SET ${columnName}_1 = ${prefix}||${columnName}")
    int syncColumnDataWithPrefix(String tableName, String columnName, String prefix);

    /**
     * 删除列
     *
     * @param tableName  表名
     * @param columnName 列名
     * @return 更新结果
     */
    @Update("alter table ${tableName} drop column ${columnName}")
    int deleteColumn(String tableName, String columnName);

    /**
     * 修改列名名
     *
     * @param tableName  表名
     * @param columnName 列名
     * @return 更新结果
     */
    @Update("alter table ${tableName} rename column ${columnName}_1 to ${columnName}")
    int renameColumn(String tableName, String columnName);

    /**
     * 获取注释
     *
     * @param tableName  表名
     * @param columnName 列名
     * @return 注释
     */
    @Select("SELECT T.COMMENTS FROM user_col_comments T WHERE " +
            "T.table_name = #{tableName} " +
            "AND T.column_name = #{columnName}\n")
    String getColumComment(String tableName, String columnName);

    /**
     * 修改列类型
     *
     * @param tableName  表名
     * @param columnName 列名
     * @param targetType 列类型
     * @return 更新结果
     */
    @Update("alter table ${tableName} add ${columnName}_1 ${targetType}\n")
    int addTargetColumn(String tableName, String columnName, String targetType);

    /**
     * 剪切列数据
     *
     * @param tableName  表名
     * @param columnName 列名
     * @param length     前缀长度
     * @return 更新结果
     */
    @Update("UPDATE ${tableName} SET ${columnName} = SUBSTR(${columnName},#{length})")
    int syncColumnWithSub(String tableName, String columnName, int length);
}
