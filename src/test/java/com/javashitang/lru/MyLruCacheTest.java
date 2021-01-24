package com.javashitang.lru;

import org.junit.Test;

/**
 * @author lilimin
 * @since 2021-01-17
 */
public class MyLruCacheTest {

    @Test
    public void get() {
        MyLruCache<String, String> myLruCache = new MyLruCache<>(3);
        myLruCache.put("5", "5");
        System.out.println(myLruCache);
        myLruCache.put("3", "3");
        System.out.println(myLruCache);
        myLruCache.put("4", "4");
        System.out.println(myLruCache);
        myLruCache.put("2", "2");
        System.out.println(myLruCache);
        myLruCache.get("3");
        System.out.println(myLruCache);
    }
}