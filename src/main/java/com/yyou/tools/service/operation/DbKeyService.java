package com.yyou.tools.service.operation;

import com.yyou.tools.entity.operation.AutoIncreaseId;
import com.yyou.tools.dao.operation.IdIncreaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbKeyService implements IDbKeyGetter {

    @Autowired
    private IdIncreaseDao idIncreaseDao;

    @Override
    public AutoIncreaseId insertIncrease(AutoIncreaseId entity) {
        int effceeCount = idIncreaseDao.insertIncrease(entity);
        return entity;
    }

    @Override
    public int insertIncreaseOptions(AutoIncreaseId entity) {
        int effceeCount = idIncreaseDao.insertIncreaseOptions(entity);
        return effceeCount;
    }

    @Override
    public int batchInsert(List<AutoIncreaseId> entities) {
        return idIncreaseDao.batchInsert(entities);
    }

    @Override
    public int batchInsertScript(List<AutoIncreaseId> entities) {
        int count = idIncreaseDao.batchInsertScript(entities);
        return  count;
    }
}
