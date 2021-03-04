package com.javashitang.concurrent.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author lilimin
 * @since 2021-03-03
 */
public class CyclicBarrierUseCase1 {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService service = Executors.newCachedThreadPool();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int num = i;
            service.submit(() -> {
                try {
                    System.out.println(num + " 准备去棋牌馆");
                    TimeUnit.SECONDS.sleep(random.nextInt(5));
                    System.out.println(num + " 到达");
                    barrier.await();
                    System.out.println(num + " 斗地主");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
