package com.yyou.tools.dao;

import com.yyou.data.PagedQuery;
import com.yyou.tools.dto.user.QueryUserDto;
import com.yyou.tools.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
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

    @Select({"<script>",
            "select id,name,password,description from user",
            "<where>",
                "<if test=\"name!=null\"> name = #{name}</if>",
                "<if test=\"description!=null\"> and  description like CONCAT(#{description},'%')</if>",
            "</where>",
            "</script>"})
    List<User> getUserByPage(QueryUserDto userDto);
}
