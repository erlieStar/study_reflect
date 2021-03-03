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
                    System.out.println("no " + num + " check");
                    TimeUnit.SECONDS.sleep((long) Math.random() * 200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println("---- " + "no " + num + " finish");
                }
            };
            service.execute(runnable);
        }
    }
}
