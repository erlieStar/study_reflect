package com.javashitang.lockSupport;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author lilimin
 * @since 2021-02-20
 */
public class LockSupportTest {

    @Test
    public void test1() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                LockSupport.park();
                System.out.println("start");
            }
        });
        thread.start();
        thread.interrupt();
        TimeUnit.MICROSECONDS.sleep(20);
    }
}
