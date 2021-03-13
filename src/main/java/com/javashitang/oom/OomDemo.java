package com.javashitang.oom;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-03-13
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
