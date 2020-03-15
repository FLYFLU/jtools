package com.yyou.tools.mapper;

import com.yyou.tools.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserMapper {
    @Select("select id,name,password,description from user where id = #{id}")
    User getUserById(@Param("id") long id);

    @Insert("insert into user (id,name,password,description) values (#{id},#{name},#{password},#{description})")
    int addUser(User user);

    @Update({"<script>",
            "update user",
            "<set>",
            "<if test=\"name!=null\"> name = #{name},</if>",
            "<if test=\"description!=null\">  description = #{description}</if>",
            "</set>",
            "where id = #{id}",
            "</script>"
    })
    int updateUser(User user);
}
