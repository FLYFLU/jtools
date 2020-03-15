package com.yyou.tools.controller.sample;

import com.yyou.tools.util.IdGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("id")
@Api(description = "获取id")
public class IdController {
    @Autowired
    private IdGenerator idGenerator;

    @GetMapping()
    public long getId(){
        return idGenerator.getId();
    }
}
