package com.javashitang.schedule;

import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author lilimin
 * @since 2021-04-22
 */
public class TimerDemo {

    public static class MyTimerTask extends TimerTask {

        @SneakyThrows
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public static void main(String[] args) throws IOException {
        // 只会被调度一次
        Timer timer = new Timer();
        System.out.println(System.currentTimeMillis());
        timer.schedule(new MyTimerTask(), 2000);
        System.in.read();
    }
}
