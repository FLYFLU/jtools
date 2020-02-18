package com.yyou.tools;

import com.yyou.tools.service.IDJService;
import com.yyou.tools.service.IIdjService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = IDJService.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class IDJServiceTest {
    @Autowired
    private IIdjService iIdjService;

    @Test
    public void testLogin(){
        iIdjService.login("340221199308051253","22884628");
    }
}
