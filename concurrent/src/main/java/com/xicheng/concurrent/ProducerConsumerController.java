package com.xicheng.concurrent;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerController {

    private static ArrayList<Food> arrayList = new ArrayList<>(10);
    private static int size = arrayList.size();
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            if (size > 10 || size < 0) {
                throw new RuntimeException();
            }
            executorService.submit(new MakeThread());
            executorService.submit(new EatThread());
        }
    }

    static class MakeThread implements Runnable {

        @Override
        public synchronized void run() {
            while (size != 10) {
                System.out.println("I am making food");
                size++;
                this.notifyAll();
            }
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class EatThread implements Runnable {

        @Override
        public synchronized void run() {
            while (size != 0) {
                System.out.println("I am eating food");
                size--;
                this.notifyAll();
            }
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Food {

}
