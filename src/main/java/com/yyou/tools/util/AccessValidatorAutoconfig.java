package com.yyou.tools.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccessValidatorAutoconfig {

    @Value("${Access.ExpireMinutes:30}")
    private int expireMinutes;

    @Bean
    public IAccessValidator getAccessValidator(){
        return new DefaultAccessValidator(expireMinutes);
    }
}
