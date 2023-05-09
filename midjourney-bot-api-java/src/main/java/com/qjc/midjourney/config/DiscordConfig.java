package com.qjc.midjourney.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * The type DiscordConfig  config.
 *
 * @author qjch
 * @email 1071643762@qq.com
 */
@Configuration
@ConfigurationProperties(prefix = "discord")
@Data
public class DiscordConfig {
    private String userToken;
    private String botToken;
    private String serverId;
    private String channelId;
}
