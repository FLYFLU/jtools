package com.yyou.tools.dao;

import com.yyou.tools.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    @Select({"Select r.id r.name",
    "from user_role ur",
    "join role r",
    "on ur.roleid = r.id",
    "WHERE ur.userid = #{userid}"})
    List<Role> getRoleByUserId(@Param("userid") long userid);
}
