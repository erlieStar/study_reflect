package com.javashitang.stopThread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-02-20
 */
public class RunTaskCase1Test {

    @Test
    public void start() throws InterruptedException {
        RunTaskCase1 runTask = new RunTaskCase1();
        runTask.start();
        TimeUnit.MILLISECONDS.sleep(5);
        System.out.println("stop task");
        runTask.stop();
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public void testInterrupt() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {}
        });
        thread.start();
        TimeUnit.MICROSECONDS.sleep(100);
        thread.interrupt();
        // true
        System.out.println(thread.isInterrupted());
        // true
        System.out.println(thread.isInterrupted());
        // true
        System.out.println(thread.isInterrupted());
    }

    @Test
    public void testInterrupt2() {
        Thread.currentThread().interrupt();
        // true
        System.out.println(Thread.interrupted());
        // false
        System.out.println(Thread.interrupted());
        // false
        System.out.println(Thread.interrupted());
    }
}