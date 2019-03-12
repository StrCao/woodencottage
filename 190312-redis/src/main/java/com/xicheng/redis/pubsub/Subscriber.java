package com.xicheng.redis.pubsub;

import redis.clients.jedis.JedisPubSub;

/**
 * @author xichengxml
 * @date 2019/3/12 13:59
 */
public class Subscriber extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        System.out.println("Message received, channel:" + channel + ", message:" + message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("Subscribe success, channel:" + channel + ", subscribedChannels:" + subscribedChannels);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("unsubscribe success, channel:" + channel + ", subscribedChannels:" + subscribedChannels);
    }
}
