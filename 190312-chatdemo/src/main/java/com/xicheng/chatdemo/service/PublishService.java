package com.xicheng.chatdemo.service;

/**
 * @author xichengxml
 * @date 2019/3/12 15:59
 */
public interface PublishService {

    /**
     * 发布消息
     * @param message 消息内容
     */
    void publish(String message);

    /**
     * 向指定的channel发送消息
     * @param message
     * @param channel
     */
    void publish(String channel, String message);
}
