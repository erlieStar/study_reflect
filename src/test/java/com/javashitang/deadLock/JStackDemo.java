package com.javashitang.deadLock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-07-09
 */
public class JStackDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Thread threadA = new Thread(() -> {
            latch.countDown();
        });
        threadA.setName("threadA");
        Thread threadB = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        });
        threadB.setName("threadB");
        threadA.start();
        threadB.start();
        latch.await();
        System.out.println("finish");
    }
}
