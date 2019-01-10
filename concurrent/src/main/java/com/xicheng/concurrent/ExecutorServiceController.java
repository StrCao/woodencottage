package com.xicheng.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xichengxml
 * @date 2019/1/8 15:44
 */
public class ExecutorServiceController {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        InvokeTask task01 = new InvokeTask("task01", 1000);
        InvokeTask task02 = new InvokeTask("task02", 2000);
        InvokeTask task03 = new InvokeTask("task03", 3000);
        InvokeTask task04 = new InvokeTask("task04", 4000);
        InvokeTask task05 = new InvokeTask("task05", 5000);

        List<InvokeTask> taskList = new ArrayList<>(5);
        Collections.addAll(taskList, task01, task02, task03, task04, task05);

        List<Future<ResponseMsg>> futures = new ArrayList<>();
        try {
            futures = executorService.invokeAll(taskList, 4, TimeUnit.SECONDS);
            // futures = executorService.invokeAll(taskList);
        } catch (InterruptedException e) {
            System.out.println("do nothing");
        }

        long middle = System.nanoTime();
        for (int i = 0; i < futures.size(); i++) {
            try {
                System.out.println(futures.get(i).get(1, TimeUnit.NANOSECONDS));
            } catch (Exception e) {
                futures.get(i).cancel(true);
                e.printStackTrace();
            }
        }
        System.out.println("取值耗时：" + (System.nanoTime() - middle));
        System.out.println("运行耗时：" + (System.currentTimeMillis() - start));

    }
}

class InvokeTask implements Callable<ResponseMsg> {

    private String name;
    private int timeout;

    public InvokeTask() {
    }

    public InvokeTask(String name, int timeout) {
        this.name = name;
        this.timeout = timeout;
    }

    @Override
    public ResponseMsg call() throws Exception {
        Thread.sleep(timeout);
        System.out.println("Task " + name + " finished");
        return new ResponseMsg(name);
    }
}

class ResponseMsg {
    private String message;

    public ResponseMsg() {
    }

    public ResponseMsg(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseMsg{" +
                "message='" + message + '\'' +
                '}';
    }
}