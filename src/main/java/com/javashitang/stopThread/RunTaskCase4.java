package com.javashitang.stopThread;

import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-02-20
 */
public class RunTaskCase4 {

    private Thread taskThread;

    public void start() {
        taskThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println("doSomething");
                    TimeUnit.MICROSECONDS.sleep(100);
                } catch (InterruptedException e) {
                    // 重新设置标志位
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        });
        taskThread.start();
    }

    public void stop() {
        taskThread.interrupt();
    }
}
