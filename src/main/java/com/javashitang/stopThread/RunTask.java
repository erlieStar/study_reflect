package com.javashitang.stopThread;

/**
 * @author lilimin
 * @since 2021-02-20
 */
public class RunTask {

    private volatile boolean stopFlag;
    private Thread taskThread;

    public void start() {
        taskThread = new Thread(() -> {
            while (!stopFlag) {
                System.out.println("doSomething");
            }
        });
        taskThread.start();
    }

    public void stop() {
        stopFlag = true;
    }
}
