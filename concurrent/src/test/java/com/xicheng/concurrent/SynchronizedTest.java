package com.xicheng.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xichengxml
 * @date 2018/12/24
 * @description
 */
public class SynchronizedTest extends Thread{
    private static int i = 1;
    private static AtomicInteger ai = new AtomicInteger(1);
    private static final ThreadLocal<Integer> THREAD_LOCAL = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return ai.getAndIncrement();
        }
    };
    @Override
    public synchronized void run() {
        i++;
        ai.getAndIncrement();
        Integer integer = THREAD_LOCAL.get();
        integer++;
    }

    public static void main(String[] args) throws Exception {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        for (int i = 0; i < 100; i++) {
            atomicInteger.getAndIncrement();
            new SynchronizedTest().start();
        }
        // 要保证所有线程都跑完，否则会出错
        Thread.sleep(5000);
        System.out.println(SynchronizedTest.i);
        System.out.println(SynchronizedTest.ai);
        System.out.println(atomicInteger);
        System.out.println(SynchronizedTest.THREAD_LOCAL.get());
    }
}
