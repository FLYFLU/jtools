package com.yyou.tools.mapper;

import com.yyou.tools.ToolsApplication;
import com.yyou.tools.dto.idj.AddIdjUserDto;
import com.yyou.tools.entity.IDJUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = ToolsApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
public class mapstructTest {

    @Autowired
    private IdjUserMapper idjUserMapper;

    @Test
    public void testMapper(){
        AddIdjUserDto dto = new AddIdjUserDto();
        dto.setIdcard("12345");
        dto.setPassword("123456");
        dto.setUsername("test");
        IDJUser idjUser =  idjUserMapper.addDto2Entity(dto);
        System.out.print(idjUser.toString());
    }
}
