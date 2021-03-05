package com.javashitang.deadLock;

import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-03-05
 */
public class DeadLockDemo {

    private static Object lockA = new Object();
    private static Object lockB = new Object();


    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {
            synchronized (lockA) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("get lockA");
                synchronized (lockB) {
                    System.out.println("threadA run finish");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (lockB) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("get lockB");
                synchronized (lockA) {
                    System.out.println("threadB run finish");
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
