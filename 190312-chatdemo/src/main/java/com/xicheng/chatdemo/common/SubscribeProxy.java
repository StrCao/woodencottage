package com.xicheng.chatdemo.common;

import com.xicheng.chatdemo.service.impl.SubscribeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author xichengxml
 * @date 2019/3/12 16:05
 */
@Configuration
public class SubscribeProxy {

    private static final String CHANNEL = "mychannel";

    /**
     * redis订阅
     */
    @Autowired
    private SubscribeServiceImpl subscribeService;

    @Autowired
    private JedisPool jedisPool;

    /**
     * 初始化方法，订阅主题
     */
    public void init() {
        Jedis jedis = jedisPool.getResource();
        System.out.println("waiting for subscribe...");
        jedis.subscribe(subscribeService, CHANNEL);
    }

}
