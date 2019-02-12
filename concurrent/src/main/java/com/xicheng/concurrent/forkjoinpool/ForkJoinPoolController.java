package com.xicheng.concurrent.forkjoinpool;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author xichengxml
 * @date 2019/2/12 14:10
 * 用于提供ForkJoinPool的一个使用实例
 */
@Slf4j
public class ForkJoinPoolController {

    /**
     * 对比通过循环和通过forkjoinpool计算从1加到10的结果和运行时间
     * 实现思路：加一个数字等待100ms
     * forkjoinpool时间稍长些
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        long start = System.currentTimeMillis();
        int count = 0;
        for (int i = 1; i < 10; i++) {
            count += i;
            Thread.sleep(100);
        }
        System.out.println(count);
        long middle = System.currentTimeMillis();
        System.out.println("Common Loop runtime:" + (middle - start));

        CountThread countThread = new CountThread(1, 10);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> future = forkJoinPool.submit(countThread);
        System.out.println(future.get());
        long end = System.currentTimeMillis();
        System.out.println("ForkJoinPool runtime:" + (end - middle));
    }

    static class CountThread implements Callable<Integer> {
        /**
         * 计数开始位置
         */
        private int start;
        /**
         * 计数结束位置
         */
        private int end;

        private int result = 0;

        public CountThread(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            for (int i = start; i < end; i++) {
                result += i;
                Thread.sleep(100);
            }
            return result;
        }
    }
}
