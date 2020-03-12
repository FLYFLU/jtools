package com.yyou.tools.controller.sample;

import com.yyou.tools.dto.ValidationDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "validation")
public class ValidationController {

    @RequestMapping(method = RequestMethod.GET)
    public int validateDto(@Validated ValidationDto dto){
        return 1;
    }

}
