package com.xicheng.concurrent.sychronized;

public class SychronizedController {

    public static void main(String[] args) throws Exception {
        CountTask countTask = new CountTask();
        for (int i = 0; i < 10000; i++) {
            new Thread(countTask).start();
        }

        Thread.sleep(60000);
        System.out.println(countTask.getCnt01());
        System.out.println(countTask.getCnt02());
    }
}
