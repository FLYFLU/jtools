package com.yyou.tools.controller.rx.word;

import com.yyou.data.CustomResponse;
import com.yyou.tools.dto.rx.word.GetWordTableContentInput;
import com.yyou.tools.service.rx.word.IWordService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * word数据生成器
 */
@Api(tags = "word文档生成sql")
@RestController
@RequestMapping("/rx/word")
public class WordController {

    private IWordService wordService;

    @PostMapping("/getWordTableContent")
    public CustomResponse<List<Map<String, Object>>> getWordTableContent(GetWordTableContentInput input, MultipartFile file)
            throws IOException {
        return CustomResponse.http200(wordService.getWordTableContent(input, file));
    }

    @GetMapping("/getSql")
    public CustomResponse<String> getSql(GetWordTableContentInput input, MultipartFile file)
            throws IOException {
        return CustomResponse.http200(wordService.getSql(input, file));
    }

    // region getter and setter

    public IWordService getWordService() {
        return wordService;
    }

    @Autowired
    public void setWordService(IWordService wordService) {
        this.wordService = wordService;
    }

    // endregion
}
