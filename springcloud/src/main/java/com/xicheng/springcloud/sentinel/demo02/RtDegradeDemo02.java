package com.xicheng.springcloud.sentinel.demo02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xichengxml
 * @date 2019/1/18 14:55
 */
public class RtDegradeDemo02 {

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = new ThreadPoolExecutor(4, 100, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
        long start = System.currentTimeMillis();
        List<RtDegradeTask02> taskList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            RtDegradeTask02 rtDegradeTask02 = new RtDegradeTask02("key" + i % 5, i * 10);
            taskList.add(rtDegradeTask02);
        }
        executorService.invokeAll(taskList);
        System.out.println("RunTime:" + (System.currentTimeMillis() - start));
    }
}
