package com.yyou.tools.service.rx.table.impl;

import com.yyou.tools.annotations.UnTest;
import com.yyou.tools.dao.rx.ITableSyncDao;
import com.yyou.tools.dto.rx.table.ChangeColumDefInut;
import com.yyou.tools.dto.rx.table.ChangeNvarchar2VarcharInput;
import com.yyou.tools.dto.rx.table.SubColumPrefixInput;
import com.yyou.tools.exception.BizException;
import com.yyou.tools.service.rx.table.ITableSyncService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
class TableSyncServiceImpl implements ITableSyncService {

    private final ITableSyncDao tableSyncDao;

    TableSyncServiceImpl(ITableSyncDao tableSyncDao) {
        this.tableSyncDao = tableSyncDao;
    }

    @Override
    public void changeNvarchar2Varchar(ChangeNvarchar2VarcharInput input) {
        List<Map<String, Object>> tableMapList = tableSyncDao.getNvarcharColumns(input.getTableName());
        for (Map<String, Object> tableMap : tableMapList) {
            String columnName = tableMap.get("COLUMN_NAME").toString();
            String dataLength = tableMap.get("DATA_LENGTH").toString();
            String comment = StringUtils.isEmpty(tableMap.get("COMMENTS")) ? "" : tableMap.get("COMMENTS").toString();
            tableSyncDao.addVarcharColumn(input.getTableName(), columnName, dataLength);
            tableSyncDao.addCommnet(input.getTableName(), columnName, comment);
            tableSyncDao.syncColumnData(input.getTableName(), columnName);
            tableSyncDao.deleteColumn(input.getTableName(), columnName);
            tableSyncDao.renameColumn(input.getTableName(), columnName);
        }
    }

    @Override
    @UnTest
    public void changeColumDef(ChangeColumDefInut input) {
        String comment = tableSyncDao.getColumComment(input.getTableName(), input.getColumnName());
        tableSyncDao.addTargetColumn(input.getTableName(), input.getColumnName(), input.getTargetTypeName());
        tableSyncDao.addCommnet(input.getTableName(), input.getColumnName(), comment);
        if (StringUtils.isEmpty(input.getPrefix())) {
            tableSyncDao.syncColumnData(input.getTableName(), input.getColumnName());
        } else {
            tableSyncDao.syncColumnDataWithPrefix(input.getTableName(), input.getColumnName(), input.getPrefix());
        }
        tableSyncDao.deleteColumn(input.getTableName(), input.getColumnName());
        tableSyncDao.renameColumn(input.getTableName(), input.getColumnName());
    }

    @Override
    @UnTest
    public void subColumPrefix(SubColumPrefixInput input) {
        if (StringUtils.isEmpty(input.getPrefix())) {
            throw new BizException("前缀错误");
        }
        int length = input.getPrefix().length() + 1;
        tableSyncDao.syncColumnWithSub(input.getTableName(), input.getColumnName(), length);
    }
}
