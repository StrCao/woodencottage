package com.xicheng.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xichengxml
 * @date 2019/1/8 15:44
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 可以做AOP功能
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new MainTask());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        InvokeTask task01 = new InvokeTask("task01", cyclicBarrier, 1000);
        InvokeTask task02 = new InvokeTask("task02", cyclicBarrier, 2000);
        InvokeTask task03 = new InvokeTask("task03", cyclicBarrier, 3000);
        InvokeTask task04 = new InvokeTask("task04", cyclicBarrier, 4000);
        InvokeTask task05 = new InvokeTask("task05", cyclicBarrier, 5000);

        List<InvokeTask> taskList = new ArrayList<>(5);
        Collections.addAll(taskList, task01, task02, task03, task04, task05);

        List<Future<ResponseMsg>> futures = new ArrayList<>();
        try {
            futures = executorService.invokeAll(taskList, 4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("do nothing");
        }

        for (int i = 0; i < futures.size(); i++) {
            try {
                System.out.println(futures.get(i).get(1, TimeUnit.NANOSECONDS));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }
}

class MainTask extends Thread {

    @Override
    public void run() {
        System.out.println("主任务执行");
    }
}
class InvokeTask implements Callable<ResponseMsg> {

    private String name;
    private CyclicBarrier cyclicBarrier;
    private int timeout;

    public InvokeTask() {
    }

    public InvokeTask(String name, CyclicBarrier cyclicBarrier, int timeout) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
        this.timeout = timeout;
    }

    @Override
    public ResponseMsg call() throws Exception {
        cyclicBarrier.await(1, TimeUnit.SECONDS);
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