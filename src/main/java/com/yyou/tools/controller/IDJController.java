package com.yyou.tools.controller;

import com.yyou.data.CustomResponse;
import com.yyou.tools.dto.idj.AddIdjUserDto;
import com.yyou.tools.dto.idj.UpdateIdjUserDto;
import com.yyou.tools.entity.IDJUser;
import com.yyou.tools.exception.HttpRequestException;
import com.yyou.tools.service.IDjUserService;
import com.yyou.tools.service.IIdjService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Api(description = "爱党建")
@RestController
@RequestMapping("idj")
public class IDJController {

    @Autowired
    private IIdjService iIdjService;
    @Autowired
    private IDjUserService iDjUserService;

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public CustomResponse login(@RequestParam("name") String name, @RequestParam("password") String password)
        throws HttpRequestException,IOException {
        String messeage = iIdjService.login(name,password);
        return CustomResponse.http200(messeage);
    }

    @RequestMapping(value = "users/{id}",method = RequestMethod.GET)
    public IDJUser getUser(@PathVariable("id") long id){
        IDJUser user = iDjUserService.getUser(id);
//        IDjRelation sysUser = user.getUser();
        return user;
    }

    @PostMapping(value = "users")
    public CustomResponse addIdjUser(@RequestBody AddIdjUserDto dto){
        iDjUserService.addIdjUser(dto);
        return CustomResponse.http200("新增成功");
    }

    @PostMapping(value = "users/{id}")
    public CustomResponse updateIdjUser(@PathVariable("id") long id,
                                        @RequestBody UpdateIdjUserDto dto){
        iDjUserService.updateIdjUser(id,dto);
        return CustomResponse.http200("修改成功");
    }
}
