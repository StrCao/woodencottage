package com.xicheng.redis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Scanner;

/**
 * @author xichengxml
 * @date 2019/3/12 13:53
 */
public class Publisher extends Thread {

    private JedisPool jedisPool;

    public Publisher(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        // 从连接池中取出一个连接
        Jedis jedis = jedisPool.getResource();
        while (true) {
            System.out.println("Pls input something(input q to quit): ");
            String line = scanner.nextLine();
            if ("q".equals(line)) {
                break;
            }
            jedis.publish("mychannel", line);
        }
    }
}

