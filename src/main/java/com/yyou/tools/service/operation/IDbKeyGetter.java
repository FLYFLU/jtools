package com.yyou.tools.service.operation;

import com.yyou.tools.entity.operation.AutoIncreaseId;

public interface IDbKeyGetter {
    AutoIncreaseId insertIncrease(AutoIncreaseId entity);

    int insertIncreaseOptions(AutoIncreaseId entity);
}
