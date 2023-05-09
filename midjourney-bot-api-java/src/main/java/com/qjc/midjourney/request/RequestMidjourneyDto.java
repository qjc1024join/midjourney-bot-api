/**
  * Copyright 2023 json.cn 
  */
package com.qjc.midjourney.request;

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
public class RequestMidjourneyDto {
    @Builder.Default
    private int type = 2;
    @Builder.Default
    private String application_id = "936929561302675456";
    private String guild_id;
    private String channel_id;
    @Builder.Default
    private String session_id = "9c4055428e13bcbf2248a6b36084c5f3";
    private RequestMidjourneyData data;


}