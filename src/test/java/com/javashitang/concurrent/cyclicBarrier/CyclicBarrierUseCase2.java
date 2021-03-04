package com.javashitang.concurrent.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-03-03
 */
public class CyclicBarrierUseCase2 {

    public static void main(String[] args) {
        CyclicBarrier barrier =
                new CyclicBarrier(4, () -> System.out.println("凑够人了"));
        ExecutorService service = Executors.newCachedThreadPool();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int num = i;
            service.submit(() -> {
                try {
                    System.out.println(num + " 准备去麻将馆");
                    TimeUnit.SECONDS.sleep(random.nextInt(5));
                    System.out.println(num + " 到达麻将馆");
                    barrier.await();
                    System.out.println(num + " 开始打");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
