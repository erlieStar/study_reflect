package com.javashitang.stopThread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-02-20
 */
public class RunTaskCase3Test {

    @Test
    public void start() throws InterruptedException {
        RunTaskCase3 runTask = new RunTaskCase3();
        runTask.start();
        TimeUnit.MILLISECONDS.sleep(5);
        System.out.println("stop task");
        runTask.stop();
        TimeUnit.SECONDS.sleep(3);
    }
}