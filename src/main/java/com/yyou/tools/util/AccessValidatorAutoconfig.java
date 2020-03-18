package com.yyou.tools.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccessValidatorAutoconfig {

    @Bean
    public IAccessValidator getAccessValidator(){
        return new DefaultAccessValidator();
    }
}
