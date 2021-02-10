package com.javashitang.concurrent.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-02-10
 */
public class CountDownLatchUseCase1 {

    public static void main(String[] args) throws InterruptedException{
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int num = i;
            service.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(random.nextInt(5));
                    System.out.println(num + " 号运动员完成比赛");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }
        System.out.println("等待运动员都跑完");
        latch.await();
        System.out.println("运动员都跑完，裁判宣布比赛结束");
    }

}
