package com.qjc.midjourney.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class MidjourneyBotConfiguration {

    private final DiscordConfig discordConfig;

    private final CallBackConfig callBackConfig;

    @Autowired
    public MidjourneyBotConfiguration(DiscordConfig discordConfig, CallBackConfig callBackConfig) {
        this.discordConfig = discordConfig;
        this.callBackConfig = callBackConfig;
    }

}