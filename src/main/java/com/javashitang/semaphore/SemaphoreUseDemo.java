package com.javashitang.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-02-20
 */
public class SemaphoreUseDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 8; i++) {
            final int num = i;
            Runnable runnable = () -> {
                try {
                    semaphore.acquire();
                    System.out.println("no " + num + " access");
                    TimeUnit.SECONDS.sleep((long) Math.random() * 5);
                    semaphore.release();
                    System.out.println("----" + semaphore.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            service.execute(runnable);
        }
        service.shutdownNow();
    }
}
