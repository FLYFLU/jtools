package com.yyou.tools.provider.operation;

import com.yyou.tools.entity.operation.AutoIncreaseId;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DbKeyBatchInsertProvider {
    //mybatis 只会传过来名叫list,其他名称无效
//    @Param()解决
    //翻译错误
//    翻译成 insert into table (col) values(var1 ,var2)
    public String insertBatch(List<AutoIncreaseId> entities){
//        List<String> remarks = entities.stream().map(a -> a.getRemark()).collect(Collectors.toList());
        SQL sql = new SQL()
                .INSERT_INTO("id_increase");
//                .INTO_COLUMNS("remark")
//                .INTO_VALUES("#{remark}");
        for (AutoIncreaseId autoIncreaseId:entities){
            sql.VALUES("remark",autoIncreaseId.getRemark());
        }
        return  sql.toString();
    }
}
