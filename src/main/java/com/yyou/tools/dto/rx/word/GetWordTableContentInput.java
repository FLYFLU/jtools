package com.yyou.tools.dto.rx.word;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class GetWordTableContentInput {
    /**
     * 表格序号
     */
    @ApiModelProperty(value = "表格序号", required = false)
    private Integer tableIndex;

    /**
     * 起始数据行
     */
    private Integer rowIndex;

    private List<String> titleList;

    public Integer getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(Integer tableIndex) {
        this.tableIndex = tableIndex;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public List<String> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<String> titleList) {
        this.titleList = titleList;
    }
}
