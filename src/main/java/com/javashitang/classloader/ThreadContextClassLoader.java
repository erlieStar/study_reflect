package com.javashitang.classloader;

/**
 * @author lilimin
 * @since 2021-07-12
 */
public class ThreadContextClassLoader {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        ClassLoader extClassLoader = Thread.currentThread().getContextClassLoader().getParent();
        System.out.println(extClassLoader);

        Thread.currentThread().setContextClassLoader(extClassLoader);
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
