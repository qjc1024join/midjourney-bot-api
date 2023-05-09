package com.qjc.midjourney.request; /**
 * Copyright 2023 json.cn
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
  * Copyright 2023 json.cn
  */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class RequestMidjourneyOptionss {
    @Builder.Default
    private int type = 3;
    @Builder.Default
    private String name = "prompt";
    @Builder.Default
    private String description = "The prompt to imagine";
    @Builder.Default
    private boolean required = true;

}