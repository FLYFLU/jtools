package com.yyou.tools.controller.rx.table;

import com.yyou.data.CustomResponse;
import com.yyou.tools.dto.rx.table.ChangeNvarchar2VarcharInput;
import com.yyou.tools.dto.rx.word.GetWordTableContentInput;
import com.yyou.tools.service.rx.table.ITableSyncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    public ITableSyncService getTableSyncService() {
        return tableSyncService;
    }

    @Autowired
    public void setTableSyncService(ITableSyncService tableSyncService) {
        this.tableSyncService = tableSyncService;
    }
}
