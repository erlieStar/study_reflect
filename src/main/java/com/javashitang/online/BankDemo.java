package com.javashitang.online;

import lombok.SneakyThrows;

import javax.jws.soap.SOAPBinding;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lilimin
 * @since 2020-09-19
 */
public class BankDemo {

    public ExecutorService service = Executors.newFixedThreadPool(5);

    public static class Task implements Runnable {

        private CountDownLatch latch;

        public void setLatch(CountDownLatch latch) {
            this.latch = latch;
        }

        @SneakyThrows
        @Override
        public void run() {
            // 建立一个Socket连接发送数据
            Socket socket = new Socket("127.0.0.1",10006);
            // ...
            // 执行最后调用如下方法
            latch.countDown();
        }
    }

    // 真实的代码这里的过程为，每次往线程池里面放一批任务，这一批任务执行完毕，再放下一批任务
    // 即循环调用如下方法
    @SneakyThrows
    public void runTask(List<Task> taskList) {
        CountDownLatch latch = new CountDownLatch(5);
        taskList.forEach(item -> {
            item.setLatch(latch);
            service.submit(item);
        });
        latch.await();
    }
}
