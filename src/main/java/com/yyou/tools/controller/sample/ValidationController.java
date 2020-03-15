package com.yyou.tools.controller.sample;

import com.yyou.tools.dto.ValidationDto;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "validation")
@Api(description = "自定义Dto验证")
public class ValidationController {

    @RequestMapping(method = RequestMethod.GET)
    public int validateDto(@Validated ValidationDto dto){
        return 1;
    }

}
