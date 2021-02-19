package com.yyou.tools.dao.rx;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ITableSyncDao {
    @Select("SELECT T.TABLE_NAME, T.COLUMN_NAME, T.DATA_LENGTH, C.comments\n" +
            "  FROM user_tab_columns T\n" +
            "  LEFT JOIN user_col_comments C\n" +
            "    ON T.TABLE_NAME = C.table_name\n" +
            "   AND T.COLUMN_NAME = C.column_name\n" +
            " WHERE T.DATA_TYPE = 'NVARCHAR2'\n" +
            " AND T.TABLE_NAME  = #{tableName}")
    List<Map<String, Object>> getNvarcharColumns(@Param("tableName") String tableName);

    @Update("alter table ${tableName} add ${columnName}_1 VARCHAR2(${length})\n")
    int addVarcharColumn(String tableName, String columnName, String length);

    @Update("comment on column  ${tableName}.${columnName}_1 is '${commnet}'")
    int addCommnet(String tableName, String columnName, String commnet);

    @Update("UPDATE ${tableName} SET ${columnName}_1 = ${columnName}")
    int syncColumnData(String tableName, String columnName);

    @Update("alter table ${tableName} drop column ${columnName}")
    int deleteNvarcharColumn(String tableName, String columnName);

    @Update("alter table ${tableName} rename column ${columnName}_1 to ${columnName}")
    int renameVarcharColumn(String tableName, String columnName);
}
