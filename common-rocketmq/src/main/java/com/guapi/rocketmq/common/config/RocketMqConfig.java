package com.guapi.rocketmq.common.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RocketMqConfig {
    private String namesrvAddr;
    private String groupName;
    private String topic;
}
