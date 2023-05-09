package com.qjc.midjourney.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageType;

/**
 * @author qjc
 * @description TODO
 * @date 2023-05-06 17:17
 */

@Data

@Builder
@Accessors(chain = true)
public class CallBackData {

   /* private CallBackGuild callBackGuild;

    private CallBackMessageChannel callBackMessageChannel;

    private CallBackMember callBackMember;

    private CallBackMessageType callBackMessageType;

    private CallBackAttachment callBackAttachment;*/

}
