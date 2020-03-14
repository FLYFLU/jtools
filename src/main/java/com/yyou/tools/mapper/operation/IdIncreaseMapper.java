package com.yyou.tools.mapper.operation;

import com.yyou.tools.entity.operation.AutoIncreaseId;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

@Repository
public interface IdIncreaseMapper {
    @Insert("insert into id_increase (remark) VALUES (#{remark})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",before = false,resultType = Integer.class)
    int insertIncrease(AutoIncreaseId entity);

    @Insert("insert into id_increase (remark) VALUES (#{remark})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insertIncreaseOptions(AutoIncreaseId entity);

}
