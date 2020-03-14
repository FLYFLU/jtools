package com.yyou.tools.operation;

import com.yyou.tools.ToolsApplication;
import com.yyou.tools.entity.operation.AutoIncreaseId;
import com.yyou.tools.service.operation.IDbKeyGetter;
import com.yyou.tools.util.IdGenerator;
import com.yyou.tools.util.SnowFlake;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = ToolsApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DbKeyGetterTest {

    @Autowired
    private IDbKeyGetter keyGetter;
    @Test
    public void insertIncrease(){
        AutoIncreaseId entity = new AutoIncreaseId();
        entity.setRemark(Thread.currentThread().toString());
        keyGetter.insertIncrease(entity);
        System.out.println(entity.toString());
    }

    @Test
    public void insertIncreaseOptions(){
        AutoIncreaseId entity = new AutoIncreaseId();
        entity.setRemark(Thread.currentThread().toString());
        keyGetter.insertIncreaseOptions(entity);
        System.out.println(entity.toString());
    }
}
