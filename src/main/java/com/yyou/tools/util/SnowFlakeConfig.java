package com.yyou.tools.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@ConfigurationProperties(prefix = "tools.idGen")
@Component
//@Component
public class SnowFlakeConfig {
//    设置默认值
    @Value("${tools.idGenerator.storeId:1}")
    private long storeId;
    @Value("${tools.idGenerator.machineId:1}")
    private long machineId;
    @Value("${tools.idGenerator.sequence:1}")
    private long sequence;

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public long getMachineId() {
        return machineId;
    }

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }
}
