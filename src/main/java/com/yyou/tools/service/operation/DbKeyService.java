package com.yyou.tools.service.operation;

import com.yyou.tools.entity.operation.AutoIncreaseId;
import com.yyou.tools.mapper.operation.IdIncreaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbKeyService implements IDbKeyGetter {

    @Autowired
    private IdIncreaseMapper idIncreaseMapper;

    @Override
    public AutoIncreaseId insertIncrease(AutoIncreaseId entity) {
        int effceeCount = idIncreaseMapper.insertIncrease(entity);
        return entity;
    }

    @Override
    public int insertIncreaseOptions(AutoIncreaseId entity) {
        int effceeCount = idIncreaseMapper.insertIncreaseOptions(entity);
        return effceeCount;
    }

    @Override
    public int batchInsert(List<AutoIncreaseId> entities) {
        return idIncreaseMapper.batchInsert(entities);
    }

    @Override
    public int batchInsertScript(List<AutoIncreaseId> entities) {
        int count = idIncreaseMapper.batchInsertScript(entities);
        return  count;
    }
}
