package com.qjc.midjourney.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class RequestTrigger {
    private String type;
    private String discordMsgId;
    private String msgHash;
    private String prompt;
    private int index;
}