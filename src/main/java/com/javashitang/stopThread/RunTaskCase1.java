package com.javashitang.stopThread;

/**
 * @author lilimin
 * @since 2021-02-20
 */
public class RunTaskCase1 {

    private Thread taskThread;

    public void start() {
        taskThread = new Thread(() -> {
            while (true) {
                System.out.println("doSomething");
            }
        });
        taskThread.start();
    }

    public void stop() {
        taskThread.interrupt();
    }
}
