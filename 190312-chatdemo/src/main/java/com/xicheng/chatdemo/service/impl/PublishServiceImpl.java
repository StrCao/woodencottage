package com.xicheng.chatdemo.service.impl;

import com.xicheng.chatdemo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author xichengxml
 * @date 2019/3/12 16:00
 * 接收发送的消息， 实时通过redis发布
 */
@Service
public class PublishServiceImpl implements PublishService {

    private static final String CHANNEL = "mychannel";

    @Autowired
    private JedisPool jedisPool;

    @Override
    public void publish(String message) {
        Jedis jedis = jedisPool.getResource();
        System.out.println("message publishing...");
        jedis.publish(CHANNEL, message);
    }
}
