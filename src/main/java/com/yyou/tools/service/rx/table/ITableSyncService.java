package com.yyou.tools.service.rx.table;

import com.yyou.tools.dto.rx.table.ChangeColumDefInut;
import com.yyou.tools.dto.rx.table.ChangeNvarchar2VarcharInput;
import com.yyou.tools.dto.rx.table.SubColumPrefixInput;

public interface ITableSyncService {
    void changeNvarchar2Varchar(ChangeNvarchar2VarcharInput input);

    /**
     * 修改列类型
     */
    void changeColumDef(ChangeColumDefInut input);

    /**
     * 剪切列
     */
    void subColumPrefix(SubColumPrefixInput input);
}
