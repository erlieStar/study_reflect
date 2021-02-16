package com.javashitang.count;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author lilimin
 * @since 2021-02-16
 */
public class CountTest {
    
    private int count = 0;

    @Test
    public void startCompare() {
        compareDetail(1, 100 * 10000);
        compareDetail(20, 100 * 10000);
        compareDetail(30, 100 * 10000);
        compareDetail(40, 100 * 10000);
    }

    /**
     * @param threadCount 线程数
     * @param times 每个线程增加的次数
     */
    public void compareDetail(int threadCount, int times) {
        try {
            System.out.println(String.format("threadCount: %s, times: %s", threadCount, times));
            long start = System.currentTimeMillis();
            testSynchronized(threadCount, times);
            System.out.println("testSynchronized cost: " + (System.currentTimeMillis() - start));

            start = System.currentTimeMillis();
            testAtomicLong(threadCount, times);
            System.out.println("testAtomicLong cost: " + (System.currentTimeMillis() - start));

            start = System.currentTimeMillis();
            testLongAdder(threadCount, times);
            System.out.println("testLongAdder cost: " + (System.currentTimeMillis() - start));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testSynchronized(int threadCount, int times) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            threadList.add(new Thread(()-> {
                for (int j = 0; j < times; j++) {
                    add();
                }
            }));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }
    }
    
    public synchronized void add() {
        count++;
    }

    public void testAtomicLong(int threadCount, int times) throws InterruptedException {
        AtomicLong count = new AtomicLong();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            threadList.add(new Thread(()-> {
                for (int j = 0; j < times; j++) {
                    count.incrementAndGet();
                }
            }));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }
    }

    public void testLongAdder(int threadCount, int times) throws InterruptedException {
        LongAdder count = new LongAdder();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            threadList.add(new Thread(()-> {
                for (int j = 0; j < times; j++) {
                    count.increment();
                }
            }));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }
    }
}
