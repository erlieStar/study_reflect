package com.javashitang.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author lilimin
 * @since 2021-03-09
 */
public class MyThreadPool {

    /** 利用阻塞队列实现生产者-消费者模式 */
    BlockingQueue<Runnable> workQueue;

    /** 保存内部工作线程 */
    List<WorkThread> workThreadList = new ArrayList<>();

    MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        for (int i = 0; i < poolSize; i++) {
            WorkThread workThread = new WorkThread();
            workThread.start();
            workThreadList.add(workThread);
        }
    }

    void execute(Runnable command) {
        // 放入任务，如果没有空间，则阻塞等待
        try {
            workQueue.put(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    class WorkThread extends Thread {

        @Override
        public void run() {
            // 循环取任务并执行
            while (true) {
                Runnable task = null;
                try {
                    // 获取阻塞队列的第一个任务，并删除
                    // 如果没有元素，则会阻塞等待
                    task = workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task.run();
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(5);
        MyThreadPool pool = new MyThreadPool(2, workQueue);
        for (int i = 0; i < 10; i++) {
            int num = i;
            pool.execute(()->{
                System.out.println("线程 " + num + " 执行");
            });
        }
    }

}

