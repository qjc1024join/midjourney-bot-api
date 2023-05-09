package com.qjc.midjourney.request;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class ReqReSetUpscaleData {
    @Builder.Default
    private int componentType = 2;
    private String customId;

    public ReqReSetUpscaleData(String messageHash) {
        this.customId = String.format("MJ::JOB::reroll::0::%s::SOLO", messageHash);
    }

}