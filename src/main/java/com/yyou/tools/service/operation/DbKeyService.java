package com.yyou.tools.service.operation;

import com.yyou.tools.entity.operation.AutoIncreaseId;
import com.yyou.tools.mapper.operation.IdIncreaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbKeyService implements IDbKeyGetter {

    @Autowired
    private IdIncreaseMapper idIncreaseMapper;

    @Override
    public AutoIncreaseId insertIncrease(AutoIncreaseId entity) {
        int effceeCount = idIncreaseMapper.insertIncrease(entity);
        return entity;
    }
}
