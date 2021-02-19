package com.yyou.tools.service.rx.table.impl;

import com.yyou.tools.dao.rx.ITableSyncDao;
import com.yyou.tools.dto.rx.table.ChangeNvarchar2VarcharInput;
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
            tableSyncDao.deleteNvarcharColumn(input.getTableName(), columnName);
            tableSyncDao.renameVarcharColumn(input.getTableName(), columnName);
        }
    }
}
