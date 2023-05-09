package com.qjc.midjourney.service;

import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author qjc
 * @description TODO
 * @date 2023-05-06 15:59
 */
public interface DiscordInteractionService {

    public void generateImage(String prompt);

    public void upscale(int index, String messageId, String messageHash);

    public void variate(int index, String messageId, String messageHash);

    public void maxUpscale(String messageId, String messageHash);


    public void reSet(String messageId, String messageHash);
}
