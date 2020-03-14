package com.yyou.tools.util;

import com.yyou.tools.ToolsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = ToolsApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SnowFlakeTest {
    @Test
    public void testGenerate(){
        IdGenerator generator = new SnowFlake(1,1,1000);
        long id = generator.getId();
        System.out.println(id);
    }

    @Autowired
    private IdGenerator _generator;
    @Test
    public void testSnowFlakeBean(){
        long id = _generator.getId();
        System.out.println(id);
    }
}
