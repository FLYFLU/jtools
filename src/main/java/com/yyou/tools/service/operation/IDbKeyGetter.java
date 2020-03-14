package com.yyou.tools.service.operation;

import com.yyou.tools.entity.operation.AutoIncreaseId;

import java.util.List;

public interface IDbKeyGetter {
    AutoIncreaseId insertIncrease(AutoIncreaseId entity);

    int insertIncreaseOptions(AutoIncreaseId entity);

    int batchInsert(List<AutoIncreaseId> entities);

    int batchInsertScript(List<AutoIncreaseId> entities);
}
