package com.xicheng.chatdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPubSub;

/**
 * @author xichengxml
 * @date 2019/3/12 16:03
 * 接收订阅的话题的消息，实时发送给websocket
 */
@Service
public class SubscribeServiceImpl extends JedisPubSub {

    /**
     * websocket消息处理对象
     */
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void onMessage(String channel, String message) {
        System.out.println("message sending...");
        simpMessagingTemplate.convertAndSend("/topic/sub", message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("subscribe success！");
    }
}
