package com.xicheng.concurrent.lock;

/**
 * @author xichengxml
 * @date 2018/12/24
 * @description
 * 有一个更巧妙的实现方式，采用单线程分别来处理flag=1和flag=0的情况；所有的不同情况都可以采用单线程处理
 */
public class DeadLock extends Thread {

    private int flag = 0;
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    public DeadLock(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag == 0) {
            synchronized (o1) {
                System.out.println("Task o1 is running, waiting for o2...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                }
                System.out.println("Task o1 finished");
            }
        }
        if (flag == 1) {
            synchronized (o2) {
                System.out.println("Task o2 is running, waiting for o1...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                }
                System.out.println("Task o2 finished");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock(0);
        DeadLock deadLock2 = new DeadLock(1);

        deadLock1.start();
        deadLock2.start();
    }

}
