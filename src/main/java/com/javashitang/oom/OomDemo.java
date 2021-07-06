package com.javashitang.oom;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-03-13
 *
 * 打印gc日志的参数
 * -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -Xloggc:./gc.log
 *
 * 内存溢出的参数
 * -Xmx30m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/peng
 */
public class OomDemo {

    private static final int NUM = 1024;

    public static void main(String[] args) throws InterruptedException {
        List<byte[]> list = Lists.newArrayList();
        for (int i = 0; i < NUM; i++) {
            TimeUnit.SECONDS.sleep(1);
            list.add(new byte[NUM * NUM]);
        }
    }
}
