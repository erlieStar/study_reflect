package com.javashitang.javaLock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author lilimin
 * @since 2021-02-12
 */
public class MyLockTest {

    private MyLock myLock = new MyLock();

    @Test
    public void lock() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            myLock.lock();
            try {
                System.out.println("Thread1获取锁");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                System.out.println("Thread1释放锁");
                myLock.unLock();
            }
        });
        thread1.setName("t1");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            myLock.lock();
            try {
                System.out.println("Thread2获取锁");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                System.out.println("Thread2释放锁");
                myLock.unLock();
            }
        });
        thread2.setName("t2");
        thread2.start();

        thread1.join();
        thread2.join();
    }

    @Test
    public void unLock() {
    }
}