package com.qjc.midjourney.service.impl;

import com.qjc.midjourney.dto.RequestTrigger;
import com.qjc.midjourney.service.DiscordInteractionService;
import com.qjc.midjourney.service.MidjourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MidjourneyServiceImpl implements MidjourneyService {

    @Autowired
    private DiscordInteractionService discordInteractionService;
    public void executeAction(RequestTrigger requestTrigger) throws Exception {
        String type = requestTrigger.getType();
        switch (type) {
            case "generate":
                // Call GenerateImage service
                discordInteractionService.generateImage(requestTrigger.getPrompt());
                break;
            case "upscale":
                // Call ImageUpscale service
                discordInteractionService.upscale(requestTrigger.getIndex(),
                        requestTrigger.getDiscordMsgId(),
                        requestTrigger.getMsgHash());
                break;
            case "variation":
                // Call ImageVariation service
                discordInteractionService.variate(requestTrigger.getIndex(),
                        requestTrigger.getDiscordMsgId(),
                        requestTrigger.getMsgHash());
                break;
            case "maxUpscale":
                // Call ImageMaxUpscale service
                discordInteractionService.maxUpscale(  requestTrigger.getDiscordMsgId(),
                        requestTrigger.getMsgHash());
                break;
            case "reset":
                // Call ImageReset service
                discordInteractionService.reSet(requestTrigger.getDiscordMsgId(),
                        requestTrigger.getMsgHash());
                break;
            default:
                throw new Exception("Invalid type");
        }
    }
}