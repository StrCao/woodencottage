package com.xicheng.concurrent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xichengxml
 * @date 2018/12/18
 * @description
 */
@Controller
public class ThreadLocalController {
    private static final ThreadLocal<HashMap> THREAD_LOCAL = new ThreadLocal<HashMap>() {
        @Override
        protected HashMap initialValue() {
            // System.out.println(Thread.currentThread().getName() + "initialValue");
            return new HashMap();
        }
    };

    @RequestMapping("test01")
    public void test01() {
        Thread thread = new Thread();
    }

    /**
     * 源码案例
     */
    static class ThreadId {
        private static final AtomicInteger nextId = new AtomicInteger(0);

        private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                return nextId.getAndIncrement();
            }
        };

        public static int get() {
            return threadId.get();
        }
    }

    static class TestThread implements Runnable {
        // private static final HashMap MAP = new HashMap();
        // private static final HashMap MAP = THREAD_LOCAL.get(); // 写在这里也不行
        int num;

        public TestThread(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            final HashMap MAP = THREAD_LOCAL.get();
            for (int i = 0; i < 20; i++) {
                MAP.put(i, i + num * 100);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "--" + MAP.size() + "--" + MAP);
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[15];
        TestThread testThread = new TestThread(1);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(testThread);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

}
