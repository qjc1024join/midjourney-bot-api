package com.qjc.midjourney.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
public class ReqUpscaleData {
    @Builder.Default
    private int componentType = 2;
    private String customId;

    public ReqUpscaleData(int index, String messageHash) {
        this.customId = String.format("MJ::JOB::upsample::%d::%s", index, messageHash);
    }

}