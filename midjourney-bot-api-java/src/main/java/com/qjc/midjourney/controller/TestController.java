package com.qjc.midjourney.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.qjc.midjourney.service.impl.ChatServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qjc
 * @description TODO
 * @date 2023-05-06 18:02
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    /**
     * The Gpt service.
     */
    @Autowired
    private ChatServiceImpl chatServiceimpl;

    @PostMapping("/test")
    public JSONObject jsonObject (@RequestBody JSONObject jsonObject){
        log.info("/test"+jsonObject.toString());
        return jsonObject;

    }

    /**
     * Completions result.
     *
     * @param dto the dto
     * @return the result
     */

    @PostMapping(value = "/chat/completions", name = "GPT-Turbo 3.5", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result completions(@Validated @RequestBody final GptTurboDto dto) {
        log.info("==================>"+dto.toString());
        try {
            final GptTurboModel model = GptTurboDto.convertToGptTurboModel(dto);
            List<GptTurboModel.Messages> messages = model.getMessages();
            int listSize = messages.size();
            int startIndex = listSize > 5 ? listSize - 5 : 0;
            List<GptTurboModel.Messages> lastFiveMessages = messages.subList(startIndex, listSize);
            model.setMessages(lastFiveMessages);
            log.info("List<GptTurboModel.Messages>===================>"+ JSON.toJSONString(lastFiveMessages));
            return Result.data(chatServiceimpl.build(model, "chat/completions"));
        } catch (Exception e) {
            log.error("Failed to fetch GPT3.5 model API /chat/completions"+e.getMessage()+dto.toString());
            return Result.error(e.getMessage());
        }
    }
}
