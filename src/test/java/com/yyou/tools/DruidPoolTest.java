package com.yyou.tools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@SpringBootTest(classes = ToolsApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DruidPoolTest {

    @Autowired
    private DataSource source;

    @Test
    public void getDatasource(){
        Class classzz= source.getClass();
        System.out.println(source.toString());
    }
}
