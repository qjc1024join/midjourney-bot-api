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
public class ReqReSetUpscaleDiscord {
    @Builder.Default
    private int type = 3;
    private String guildId;
    private String channelId;
    @Builder.Default
    private int messageFlags = 0;
    private String messageId;
    @Builder.Default
    private String applicationId = "936929561302675456";
    @Builder.Default
    private String sessionId = "45bc04dd4da37141a5f73dfbfaf5bdcf";
    private ReqReSetUpscaleData data;

}