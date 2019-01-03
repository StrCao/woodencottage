package com.xicheng.concurrent.sychronized;

import lombok.Getter;
import lombok.Setter;

public class CountTask implements Runnable {

    @Setter
    @Getter
    private volatile int cnt01 = 1;
    @Setter
    @Getter
    private int cnt02 = 1;

    @Override
    public void run() {
        count01();
        count02();
    }

    private void count01() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cnt01++;
        System.out.println("count01--" + cnt01);
    }

        private synchronized void count02() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cnt02++;
        System.out.println("count02--" + cnt02);
    }
}
