package com.javashitang.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author lilimin
 * @since 2021-03-07
 */
public class MyLock {

    private final Sync sync;

    public MyLock() {
        sync = new Sync();
    }

    public class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, arg);
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }

    }


    public void lock() {
        sync.acquire(1);
    }

    public void unLock() {
        sync.release(1);
    }
}
