package com.xicheng.redis.pubsub;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author xichengxml
 * @date 2019/3/12 14:16
 */
public class PubSubDemo {

    public static void main(String[] args) {
        // 创建连接
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);

        // 创建发布者
        Publisher publisher = new Publisher(jedisPool);
        publisher.start();

        // 创建并初始化订阅者
        SubProxy.jedisPool = jedisPool;
        SubProxy.init();
    }
}
