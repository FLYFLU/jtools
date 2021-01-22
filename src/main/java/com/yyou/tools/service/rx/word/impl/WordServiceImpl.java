package com.yyou.tools.service.rx.word.impl;

import com.yyou.tools.dto.rx.word.GetWordTableContentInput;
import com.yyou.tools.service.rx.word.IWordService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WordServiceImpl implements IWordService {
    @Override
    public List<Map<String, Object>> getWordTableContent(GetWordTableContentInput input, MultipartFile file)
            throws IOException {
        InputStream inputStream = file.getInputStream();
        XWPFDocument xwpfDocument = new XWPFDocument(inputStream);
        List<XWPFTable> xwpfTableList = xwpfDocument.getTables();
        int tableIndex;
        if (null == input.getTableIndex()) {
            tableIndex = xwpfTableList.size() - 1;
        } else {
            tableIndex = input.getTableIndex();
        }
        XWPFTable xwpfTable = xwpfTableList.get(tableIndex);
        List<XWPFTableRow> rowList = xwpfTable.getRows();
        if (0 == rowList.size()) {
            return null;
        }
        List<Map<String, Object>> resultMapList = new ArrayList<>(rowList.size());
        int i = -1;
        int startIndex = input.getRowIndex() == null ? 1 : input.getRowIndex();
        List<String> titleList = getColKey(input.getTitleList(), rowList.get(0).getTableCells().size());
        for (XWPFTableRow row : rowList
        ) {
            i++;
            if (i < startIndex) {
                continue;
            }
            List<XWPFTableCell> cellList = row.getTableCells();
            Map<String, Object> cellMap = new HashMap<>(cellList.size());
            int j = 0;
            for (XWPFTableCell cell : cellList
            ) {
                cellMap.put(titleList.get(j), cell.getText());
                j++;
            }
            resultMapList.add(cellMap);
        }
        return resultMapList;
    }

    @Override
    public String getSql(GetWordTableContentInput input, MultipartFile file)
            throws IOException {
        List<Map<String, Object>> mapList = getWordTableContent(input, file);
        if (null == mapList) {
            return null;
        }
        StringBuilder sql = new StringBuilder();
        // todo build sql
        return sql.toString();
    }

    private List<String> getColKey(List<String> titleList, int size) {
        if (titleList != null) {
            return titleList;
        }
        List<String> keyList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            keyList.add("field_" + i);
        }
        return keyList;
    }
}
