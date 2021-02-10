package com.javashitang.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-02-10
 */
public class CountDownLatchUseCase2 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("5秒后比赛正式开始");
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int num = i;
            service.submit(() -> {
                System.out.println(num + " 号运动员准备完毕，等待开赛");
                try {
                    latch.await();
                    System.out.println(num + " 号运动员开始跑步");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println("5秒准备时间已经过去，比赛开始！");
        latch.countDown();
    }
}
