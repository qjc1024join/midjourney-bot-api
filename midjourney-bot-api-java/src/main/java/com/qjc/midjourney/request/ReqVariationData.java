package com.qjc.midjourney.request;

import lombok.Data;

@Data
public  class ReqVariationData {
        private int componentType = 2;
        private String customId;
        public ReqVariationData(int index, String messageHash) {
            this.customId = String.format("MJ::JOB::variation::%d::%s", index, messageHash);
     }
}