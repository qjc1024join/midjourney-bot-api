package com.qjc.midjourney.request;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data

public class ReqMaxUpscaleData {
    @Builder.Default
    private int componentType = 2;
    private String customId;

    public ReqMaxUpscaleData(String messageHash) {
        this.customId = String.format("MJ::JOB::variation::1::%s::SOLO", messageHash);
    }

}