package com.qjc.midjourney.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.concurrent.TimeoutException;


/**
 * The type Gpt service.
 *
 * @author bdth
 */
@Service


@Slf4j
public class ChatServiceImpl  {


    @Value("${chatgpt.token}")
    private String token;


    /**
     * The constant openUrl.
     */
    private static final String openUrl = "https://api.openai.com/v1/";





    /**
     * Http string.
     *
     * @param body the body
     * @return the string
     */
    public JSONObject build(final Object body, final String url) {

        final WebClient.Builder webClient = WebClient.builder();

        log.info("=================>WebClient start http:");

        try {
            webClient
                    .baseUrl(openUrl)
                    .defaultHeader("Authorization", "Bearer " +token);
            return JSONObject.parseObject(
                    webClient.build()
                            .post()
                            .uri(url)
                            .body(BodyInserters.fromValue(body))
                            .retrieve()
                            .bodyToMono(String.class)
                            .timeout(Duration.ofSeconds(60))
                            .onErrorMap(TimeoutException.class, e -> new Exception())
                            .block()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }


}
