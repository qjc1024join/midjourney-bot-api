package com.qjc.midjourney.event;

import com.alibaba.fastjson.JSONObject;
import com.qjc.midjourney.config.DiscordConfig;
import com.qjc.midjourney.config.MidjourneyBotConfiguration;
import com.qjc.midjourney.enums.Scene;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.MessageUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * The type DiscordEventHandler event trigger .
 *
 * @author qjch
 * @email 1071643762@qq.com
 */
@Component
@Slf4j
public class DiscordEventHandler extends ListenerAdapter {

    private final MidjourneyBotConfiguration midjourneyBotConfiguration;
    private final WebClient webClient;

    @Autowired
    public DiscordEventHandler(MidjourneyBotConfiguration midjourneyBotConfiguration, WebClient.Builder webClientBuilder) {
        this.midjourneyBotConfiguration = midjourneyBotConfiguration;
        this.webClient = webClientBuilder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        User author = event.getAuthor();

        if (!channel.getId().equals(midjourneyBotConfiguration.getDiscordConfig().getChannelId()) ||
                author.getId().equals(event.getJDA().getSelfUser().getId())) {
            return;
        }

        if (message.getContentRaw().contains("(Waiting to start)") && !message.getContentRaw().contains("Rerolling **")) {
            trigger(message.getContentRaw(), Scene.FIRST_TRIGGER);
            return;
        }

        for (Message.Attachment attachment : message.getAttachments()) {
            if (attachment.isImage()) {
                replay(attachment);
                return;
            }
        }
    }
    private void test(){
      /*  JSONObject jsonObject =new JSONObject();
        jsonObject.put("id", attachment.getId());
        jsonObject.put("url", attachment.getUrl());
        jsonObject.put("proxyUrl", attachment.getProxyUrl());
        jsonObject.put("fileName", attachment.getFileName());
        jsonObject.put("contentType", attachment.getContentType());
        jsonObject.put("description", attachment.getDescription());
        jsonObject.put("size", attachment.getSize());
        jsonObject.put("height", attachment.getHeight());
        jsonObject.put("width", attachment.getWidth());*/
    }

    @Override
    public void onMessageUpdate(MessageUpdateEvent event) {
        Message message = event.getMessage();
        MessageChannel channel = event.getChannel();
        User author = event.getAuthor();

        if (!channel.getId().equals(midjourneyBotConfiguration.getDiscordConfig()
                .getChannelId()) || author.getId().equals(event.getJDA().getSelfUser().getId())) {
            return;
        }

        if (message.getContentRaw().contains("(Stopped)")) {
            trigger(message.getContentRaw(), Scene.GENERATE_EDIT_ERROR);
        }
    }

    private void replay(Message.Attachment attachment ) {
      /*  //获取服务器（公会）信息
        Guild guild = message.getGuild();
        String guildId = guild.getId();
        String guildName = guild.getName();

        System.out.println("guildId = " + guildId);//输出服务器（公会）id
        System.out.println("guildName = " + guildName);//输出服务器（公会）名称

        //获取频道信息
        MessageChannel channel = message.getChannel();
        String channelId = channel.getId();
        String channelName = channel.getName();
        ChannelType channelType = channel.getType();
        System.out.println("channelId = " + channelId);//输出频道id
        System.out.println("channelName = " + channelName);//输出频道名称
        System.out.println("channelType = " + channelType);//输出频道类型

        //获取发消息人
        Member member = message.getMember();
        String memberId = member.getId();
        String memberNickname = member.getNickname();
        String memberEffectiveName = member.getEffectiveName();
        List<Role> memberRoles = member.getRoles();
        EnumSet<Permission> memberPermissions = member.getPermissions();
        OnlineStatus memberOnlineStatus = member.getOnlineStatus();
        System.out.println("memberId = " + memberId);//输出发送消息人的id
        System.out.println("memberNickname = " + memberNickname);//输出发送消息人的昵称
        System.out.println("memberEffectiveName = " + memberEffectiveName);//输出发送消息人的有效名称
        System.out.println("memberRoles = " + memberRoles);//输出发送消息人的角色列表
        System.out.println("memberPermissions = " + memberPermissions);//输出发送消息人的权限列表
        System.out.println("memberOnlineStatus = " + memberOnlineStatus);//输出发送消息人的在线状态

        //获取消息信息
        String messageId = message.getId();
        String messageContentRaw = message.getContentRaw();
        MessageType messageType = message.getType();
        System.out.println("messageId = " + messageId);//输出消息id
        System.out.println("messageContentRaw = " + messageContentRaw);//输出消息内容
        System.out.println("messageType = " + messageType);//输出消息类型*/
//截取  文件名称  hrldaiz_Cute_Magical_Flying_Dogs_fantasy_art_drawn_by_Disney_co_450bfebf-ff51-4ed3-83ec-273c665f4414.png
        String fileName = attachment.getFileName();
        String[] keys = fileName.split("_", -1);

        com.alibaba.fastjson.JSONObject jsonObject =new JSONObject();
        jsonObject.put("id", attachment.getId());
        jsonObject.put("url", attachment.getUrl());
        jsonObject.put("proxyUrl", attachment.getProxyUrl());
        jsonObject.put("fileName", attachment.getFileName());
        jsonObject.put("contentType", attachment.getContentType());
        jsonObject.put("description", attachment.getDescription());
        jsonObject.put("size", attachment.getSize());
        jsonObject.put("height", attachment.getHeight());
        jsonObject.put("width", attachment.getWidth());

        String images = keys[keys.length - 1];
        String msgHash = images.split("\\.")[0];
        jsonObject.put("msgHash",msgHash);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        jsonObject.put("date",localTime);

        //拼接路径，数据库中可以直接保存该路径，返回前端，前端即可访问
        log.info("MessageMetadataRegistry:"+jsonObject.toJSONString());
        Map<String, Object> body = new HashMap<>();
        body.put("discord", jsonObject);
        body.put("type", Scene.GENERATE_END);
        request(body);
    }





    private void trigger(String content, Scene scene) {
        Map<String, Object> body = new HashMap<>();
        body.put("content", content);
        body.put("type", scene);
        request(body);
    }

    private void request(Map<String, Object> params) {
        webClient.post()
                .uri(midjourneyBotConfiguration.getCallBackConfig().getUrl())
                .bodyValue(params)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(response -> log.info("Upscale response: " + response),
                        error -> log.error("Error: " + error.getMessage()));
    }


}