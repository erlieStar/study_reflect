package com.javashitang.lock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author lilimin
 * @since 2021-03-07
 */
public class MyLockTest {

    MyLock myLock = new MyLock();

    @Test
    public void lock() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                show();
            }).start();
        }
        TimeUnit.SECONDS.sleep(20);
    }

    public void show() {
        myLock.lock();
        try {
            System.out.println(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(2);
            System.out.println("10");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            myLock.unLock();
        }
    }
}