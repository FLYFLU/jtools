package com.yyou.tools.provider;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class IDJUserProvider {
    public String getAll(){
        return new SQL(){{
            SELECT("*");
            FROM("idjuser");
//            if(!StringUtils.isEmpty(name)){
//                WHERE("name = #{value}");
//            }
        }}.toString();
    }
}
