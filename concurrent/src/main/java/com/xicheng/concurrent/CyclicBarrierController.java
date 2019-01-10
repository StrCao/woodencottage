package com.xicheng.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xichengxml
 * @date 2019/1/9 10:29
 */
public class CyclicBarrierController {

    public static void main(String[] args) throws Exception{
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        InvokeTask invokeTask01 = new InvokeTask(cyclicBarrier, "task01", 1000);
        InvokeTask invokeTask02 = new InvokeTask(cyclicBarrier, "task02", 2000);
        InvokeTask invokeTask03 = new InvokeTask(cyclicBarrier, "task03", 3000);
        InvokeTask invokeTask04 = new InvokeTask(cyclicBarrier, "task04", 4000);
        InvokeTask invokeTask05 = new InvokeTask(cyclicBarrier, "task05", 5000);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<ResponseMsg> result01 = executorService.submit(invokeTask01);
        Future<ResponseMsg> result02 = executorService.submit(invokeTask02);
        Future<ResponseMsg> result03 = executorService.submit(invokeTask03);
        Future<ResponseMsg> result04 = executorService.submit(invokeTask04);
        Future<ResponseMsg> result05 = executorService.submit(invokeTask05);
        System.out.println(result01.get());
        System.out.println(result02.get());
        System.out.println(result03.get());
        System.out.println(result04.get(3, TimeUnit.SECONDS));
        System.out.println(result05.get(3, TimeUnit.SECONDS));

    }

    static class ResponseMsg {
        private String message;

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

    static class InvokeTask implements Callable<ResponseMsg> {
        private CyclicBarrier cyclicBarrier;
        private String message;
        private int timeout;

        public InvokeTask(CyclicBarrier cyclicBarrier, String message, int timeout) {
            this.cyclicBarrier = cyclicBarrier;
            this.message = message;
            this.timeout = timeout;
        }

        @Override
        public ResponseMsg call() throws Exception {
            try {
                cyclicBarrier.await(3, TimeUnit.SECONDS);
                Thread.sleep(timeout);
                System.out.println("This is " + message);
            } catch (Exception e) {
                //cyclicBarrier.reset();
            }
            return new ResponseMsg(message);
        }
    }
}




