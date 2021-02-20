package com.javashitang.stopThread;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author lilimin
 * @since 2021-02-20
 */
public class RunTaskTest {

    @Test
    public void start() throws InterruptedException {
        RunTask runTask = new RunTask();
        runTask.start();
        TimeUnit.MILLISECONDS.sleep(5);
        runTask.stop();
        System.out.println("stop task");
        TimeUnit.SECONDS.sleep(3);
    }
}