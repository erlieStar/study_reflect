package com.javashitang.javaLock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author lilimin
 * @since 2021-02-12
 */
public class MyLock {

    private volatile int state;
    private List<Thread> threadList = new ArrayList<>();
    private static final Unsafe unsafe;
    private static final long stateOffset;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset
                    (MyLock.class.getDeclaredField("state"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    public void lock() {
        while (!compareAndSetState(0, 1)) {
            park();
        }
    }

    public void unLock() {
        while (compareAndSetState(1, 0)) {
            unPark();
        }
    }

    private void park() {
        threadList.add(Thread.currentThread());
        LockSupport.park(Thread.currentThread());
    }

    private void unPark() {
        if (!threadList.isEmpty()) {
            Thread thread = threadList.get(0);
            System.out.println(thread.getName());
            LockSupport.unpark(thread);
        }
    }

    private boolean compareAndSetState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }
}

