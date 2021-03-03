package com.javashitang.concurrent.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author lilimin
 * @since 2021-03-03
 */
public class CyclicBarrierUseCase1 {

    public static void main(String[] args) throws InterruptedException{
        CyclicBarrier barrier = new CyclicBarrier(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = i;
            service.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(random.nextInt(5));
                    System.out.println(num + " 号运动员完成比赛");
                    barrier.await();
                    barrier.reset();
                    System.out.println("运动员都跑完，裁判宣布比赛结束");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
