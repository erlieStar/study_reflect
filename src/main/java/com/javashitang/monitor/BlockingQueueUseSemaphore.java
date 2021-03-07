package com.javashitang.monitor;

import java.util.concurrent.Semaphore;

/**
 * @author lilimin
 * @since 2021-03-07
 */
public class BlockingQueueUseSemaphore<T> {

    private final Object[] items;
    private Semaphore notFull;
    private Semaphore notEmpty;
    private Semaphore mutex;
    private int putIndex;
    private int takeIndex;

    public BlockingQueueUseSemaphore(int capacity) {
        this.items = new Object[capacity];
        notFull = new Semaphore(capacity);
        notEmpty = new Semaphore(0);
        mutex = new Semaphore(1);
    }

    public void enq(T x) throws InterruptedException {
        notFull.acquire();
        mutex.acquire();
        items[putIndex] = x;
        if (++putIndex == items.length) {
            putIndex = 0;
        }
        mutex.release();
        notEmpty.release();
    }

    public T deq() throws InterruptedException {
        notEmpty.acquire();
        mutex.acquire();
        T x = (T) items[takeIndex];
        if (++takeIndex == items.length) {
            takeIndex = 0;
        }
        mutex.release();
        notFull.release();
        return x;
    }
}
