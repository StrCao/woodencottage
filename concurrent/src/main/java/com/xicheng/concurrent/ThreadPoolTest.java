package com.xicheng.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xichengxml
 * @date 2018/12/18
 * @description
 */
public class ThreadPoolTest {

    @Test
    public void test01() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            TestThread testThread = new TestThread();
            executorService.execute(testThread);
        }
    }

    static class TestThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "is running");
        }
    }
}
