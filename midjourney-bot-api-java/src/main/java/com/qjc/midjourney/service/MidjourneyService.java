package com.qjc.midjourney.service;

import com.qjc.midjourney.dto.RequestTrigger;

/**
 * @author qjc
 * @description TODO
 * @date 2023-05-06 15:37
 */
public interface MidjourneyService {
    public void executeAction(RequestTrigger requestTrigger) throws Exception;
}
