package com.javashitang.condition;

import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-02-18
 */
public class WaitNotify {

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait());
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify());
        notifyThread.start();
    }

    private static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println("lock wait start");
                    lock.wait();
                    System.out.println("lock wait end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 条件满足，完成工作
                System.out.println("run finish");
            }
        }
    }

    private static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("lock notify start");
                lock.notify();
                System.out.println("lock notify end");
            }
        }
    }
}
