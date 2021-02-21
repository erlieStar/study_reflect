package com.javashitang.stopThread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-02-20
 */
public class RunTaskCase5Test {

    @Test
    public void start() throws InterruptedException {
        RunTaskCase5 runTask = new RunTaskCase5();
        runTask.start();
        TimeUnit.MILLISECONDS.sleep(5);
        System.out.println("stop task");
        runTask.stop();
        TimeUnit.SECONDS.sleep(3);
    }
}