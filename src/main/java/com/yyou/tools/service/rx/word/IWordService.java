package com.yyou.tools.service.rx.word;

import com.yyou.tools.dto.rx.word.GetWordTableContentInput;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IWordService {
    /**
     * word中表格获取
     *
     * @param input 参数
     * @param file  文件
     * @return 表格数据
     * @throws IOException 读取流异常
     */
    List<Map<String, Object>> getWordTableContent(GetWordTableContentInput input, MultipartFile file)
            throws IOException;

    /**
     * 生成sql
     *
     * @param input
     * @param file
     * @return
     */
    String getSql(GetWordTableContentInput input, MultipartFile file)
            throws IOException;
}
