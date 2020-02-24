package com.yyou.tools.mapper;

import com.yyou.tools.entity.IDJUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

@Repository
public interface IDJUserMapper {
    @Select("select id,username,password,idcard from idjuser where id=#{id}")
    @Results(
        {
                @Result(property = "id",column = "id"),
            @Result( property = "user",column = "id",
                one = @One(select = "com.yyou.tools.mapper.IDJRelationMapper.getByIdjUser",fetchType = FetchType.LAZY))
        }
    )
    IDJUser getById(@Param("id") int id);
}
