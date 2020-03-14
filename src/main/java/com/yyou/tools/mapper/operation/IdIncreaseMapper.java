package com.yyou.tools.mapper.operation;

import com.yyou.tools.entity.operation.AutoIncreaseId;
import com.yyou.tools.provider.operation.DbKeyBatchInsertProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdIncreaseMapper {
    @Insert("insert into id_increase (remark) VALUES (#{remark})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",before = false,resultType = Integer.class)
    int insertIncrease(AutoIncreaseId entity);

    @Insert("insert into id_increase (remark) VALUES (#{remark})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insertIncreaseOptions(AutoIncreaseId entity);

    @InsertProvider(type = DbKeyBatchInsertProvider.class,method = "insertBatch")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",before = false,keyColumn = "id",resultType = Integer.class)
    int batchInsert(@Param("entities") List<AutoIncreaseId> entities);


//    可以获取批量的id
//    id储存在集合中
    @Insert({"<script>",
            "insert into id_increase (remark) values ",
            "<foreach collection='entities' item='item' index='index' separator=','>",
            "(#{item.remark})",
            "</foreach>",
            "</script>"})
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
//    无效
//    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",keyColumn = "id",before = false,resultType = Integer.class)
    int batchInsertScript(@Param("entities") List<AutoIncreaseId> entities);

}
