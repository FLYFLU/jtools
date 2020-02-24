package com.yyou.tools.mapper;

import com.yyou.tools.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserMapper {
    @Select("select id,name,password,description from user where id = #{id}")
    User getUserById(@Param("id") String id);
}
