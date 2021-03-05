package com.javashitang.concurrent.cyclicBarrier;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-03-04
 */
public class CyclicBarrierTest {

    public class MyThread extends Thread {

        private Integer num;
        private CyclicBarrier barrier;

        public MyThread(Integer num, CyclicBarrier barrier) {
            this.num = num;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Random random = new Random();
                System.out.println(num + " 准备去麻将馆");
                TimeUnit.SECONDS.sleep(random.nextInt(5));
                System.out.println(num + " 到达麻将馆");
                barrier.await();
                System.out.println(num + " 开始打");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() throws InterruptedException {
        CyclicBarrier barrier =
                new CyclicBarrier(4, () -> System.out.println("凑够人了"));
        for (int i = 0; i < 4; i++) {
            new MyThread(i, barrier).start();
        }
        TimeUnit.SECONDS.sleep(1);
        barrier.reset();
        TimeUnit.SECONDS.sleep(10);
    }


    @Test
    public void test3() throws InterruptedException {
        CyclicBarrier barrier =
                new CyclicBarrier(4, () -> System.out.println("凑够人了"));
        for (int i = 0; i < 3; i++) {
            new MyThread(i, barrier).start();
        }
        Thread thread = new MyThread(3, barrier);
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        TimeUnit.SECONDS.sleep(5);
        for (int i = 0; i < 3; i++) {
            new MyThread(i, barrier).start();
        }
        thread = new MyThread(3, barrier);
        thread.start();
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void test6() throws InterruptedException {
        CyclicBarrier barrier =
                new CyclicBarrier(4, () -> System.out.println("凑够人了"));
        for (int i = 0; i < 3; i++) {
            new MyThread(i, barrier).start();
        }
        Thread thread = new MyThread(3, barrier);
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        TimeUnit.SECONDS.sleep(5);
        barrier.reset();
        for (int i = 0; i < 3; i++) {
            new MyThread(i, barrier).start();
        }
        thread = new MyThread(3, barrier);
        thread.start();
        TimeUnit.SECONDS.sleep(5);
    }
}
