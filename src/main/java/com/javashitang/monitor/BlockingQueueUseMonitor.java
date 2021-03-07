package com.javashitang.monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lilimin
 * @since 2021-03-07
 */
public class BlockingQueueUseMonitor<T> {

    private final Object[] items;
    private final Lock lock;
    private Condition notFull;
    private Condition notEmpty;
    private int count;
    private int putIndex;
    private int takeIndex;

    public BlockingQueueUseMonitor(int capacity) {
        this.items = new Object[capacity];
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    public void enq(T x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                // 等待队列不满
                notFull.await();
            }
            items[putIndex] = x;
            if (++putIndex == items.length) {
                putIndex = 0;
            }
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T deq() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                 notEmpty.await();
            }
            T x = (T) items[takeIndex];
            if (++takeIndex == items.length) {
                takeIndex = 0;
            }
            count--;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
