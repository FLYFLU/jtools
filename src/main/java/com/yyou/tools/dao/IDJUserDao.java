package com.yyou.tools.dao;

import com.yyou.tools.entity.IDJUser;
import com.yyou.tools.provider.IDJUserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDJUserDao {
    @Select("select id,username,password,idcard from idjuser where id=#{id}")
//    @Results(
//        {
//            @Result(property = "id",column = "id"),
//            @Result( property = "user",column = "id",
//                one = @One(select = "com.yyou.tools.mapper.IDJRelationMapper.getByIdjUser",fetchType = FetchType.LAZY))
//        }
//    )
    IDJUser getById(@Param("id") long id);

    @Insert({"<script>",
            "insert into idjuser",
            "(id,username,password,idcard)",
            "values",
            "(#{id},#{username},#{password},#{idcard})",
        "</script>"
    })
    int addIdjUser(IDJUser idjUser);

    @SelectProvider(type = IDJUserProvider.class,method = "getAll")
    List<IDJUser> getAll();

    @Update({"update idjuser",
        "set username = #{username},",
        "password = #{password},",
        "idcard = #{idcard}",
        "where id = #{id}"})
    int updateIdjUser(IDJUser idjUser);
}
