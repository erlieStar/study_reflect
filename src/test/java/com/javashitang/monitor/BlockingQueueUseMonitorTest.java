package com.javashitang.monitor;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 * @author lilimin
 * @since 2021-03-07
 */
public class BlockingQueueUseMonitorTest {

    private AtomicInteger count = new AtomicInteger(0);

    @Test
    public void enq() throws InterruptedException {

        BlockingQueueUseMonitor<Integer> queue = new BlockingQueueUseMonitor(5);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        TimeUnit.NANOSECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    produce(queue);
                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        TimeUnit.NANOSECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    consumer(queue);
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(20);
    }


    public void consumer(BlockingQueueUseMonitor queue) {
        Object num = null;
        try {
            num = queue.deq();
        } catch (Exception e) {

        }
        System.out.println("get num " + num);
    }

    public void produce(BlockingQueueUseMonitor queue) {
        int num = count.getAndIncrement();
        try {
            queue.enq(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}