package com.yyou.tools.controller.rx.table;

import com.yyou.data.CustomResponse;
import com.yyou.tools.dto.rx.table.ChangeColumDefInut;
import com.yyou.tools.dto.rx.table.ChangeNvarchar2VarcharInput;
import com.yyou.tools.dto.rx.table.SubColumPrefixInput;
import com.yyou.tools.service.rx.table.ITableSyncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "数据库表操作")
@RequestMapping("/rx/table")
public class TableSyncController {

    private ITableSyncService tableSyncService;

    /**
     * 修改nvarchar->varchar
     * 芜湖智慧住建使用
     */
    @ApiOperation(value = "修改nvarchar->varchar")
    @PostMapping("/changeNvarchar2Varchar")
    public CustomResponse<String> changeNvarchar2Varchar(ChangeNvarchar2VarcharInput input) {
        tableSyncService.changeNvarchar2Varchar(input);
        return CustomResponse.http200("OK");
    }

    /**
     * 改变列类型
     */
    @PostMapping("/changeColumDef")
    public CustomResponse<String> changeColumDef(ChangeColumDefInut input) {
        tableSyncService.changeColumDef(input);
        return CustomResponse.http200("OK");
    }

    /**
     * 剪切列
     */
    @PostMapping("/subColumPrefix")
    public CustomResponse<String> subColumPrefix(SubColumPrefixInput input) {
        tableSyncService.subColumPrefix(input);
        return CustomResponse.http200("OK");
    }


    public ITableSyncService getTableSyncService() {
        return tableSyncService;
    }

    @Autowired
    public void setTableSyncService(ITableSyncService tableSyncService) {
        this.tableSyncService = tableSyncService;
    }
}
