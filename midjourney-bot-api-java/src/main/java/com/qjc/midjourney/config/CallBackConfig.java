package com.qjc.midjourney.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/**
 * The type CallBackConfig  config.
 *
 * @author qjch
 * @email 1071643762@qq.com
 */
@Configuration
@ConfigurationProperties(prefix = "call-back")
@Data
public class CallBackConfig {
    private String url;
}