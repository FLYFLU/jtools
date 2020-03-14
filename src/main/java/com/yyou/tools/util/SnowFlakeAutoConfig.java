package com.yyou.tools.util;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowFlakeAutoConfig {
    @Bean
    @ConditionalOnClass({SnowFlakeConfig.class})
    public IdGenerator getIdGenerator(SnowFlakeConfig snowFlakeConfig){
        return new SnowFlake(snowFlakeConfig.getStoreId(),
                snowFlakeConfig.getMachineId(),
                snowFlakeConfig.getSequence());
    }
}
