package com.javashitang.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lilimin
 * @since 2021-02-18
 */
public class WaitNotifyUseCondition {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conditionA  = lock.newCondition();
    private static Condition conditionB = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThreadA = new Thread(new WaitA());
        waitThreadA.start();
        Thread waitThreadB = new Thread(new WaitB());
        waitThreadB.start();
        TimeUnit.SECONDS.sleep(2);
        lock.lock();
        try {
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }

    private static class WaitA implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("WaitA begin wait");
                conditionA.await();
                System.out.println("WaitA end wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    private static class WaitB implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("WaitB begin wait");
                conditionB.await();
                System.out.println("WaitB end wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
