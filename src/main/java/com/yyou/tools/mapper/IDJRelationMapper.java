package com.yyou.tools.mapper;

import com.yyou.tools.entity.IDjRelation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IDJRelationMapper {
    @Select("select * from sysuser_idjuser where idjuser_id = #{id}")
    @Results({
             @Result(column = "id",property = "id",id = true),
            @Result(column = "user_id" ,property = "sysId"),
            @Result(column = "idjuser_id",property = "idjId")
            }
    )
    IDjRelation getByIdjUser(@Param("id") int id);
}
