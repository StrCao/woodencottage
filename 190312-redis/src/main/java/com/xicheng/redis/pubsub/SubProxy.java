package com.xicheng.redis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author xichengxml
 * @date 2019/3/12 14:12
 */
public class SubProxy {

    private static Subscriber subscriber = new Subscriber();

    public static JedisPool jedisPool;

    private static final String CHANNEL = "mychannel";

    /**
     * 初始化订阅者
     */
    public static void init() {
        Jedis jedis = jedisPool.getResource();
        jedis.subscribe(subscriber, CHANNEL);
    }

}
