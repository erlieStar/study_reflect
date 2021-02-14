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

    // 0表示锁没有被获取，1表示锁被获取
    private volatile int state;
    // 这里应该用并发安全的容器，这里只是举例
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
        // 阻塞线程
        LockSupport.park(Thread.currentThread());
    }

    private void unPark() {
        if (!threadList.isEmpty()) {
            Thread thread = threadList.get(0);
            System.out.println(thread.getName());
            // 唤醒线程
            LockSupport.unpark(thread);
        }
    }

    private boolean compareAndSetState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }
}

