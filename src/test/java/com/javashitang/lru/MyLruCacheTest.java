package com.javashitang.lru;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lilimin
 * @since 2021-01-17
 */
public class MyLruCacheTest {

    @Test
    public void get() {
        MyLruCache<String, String> myLruCache = new MyLruCache<>(3);
        myLruCache.put("5", "5");
        myLruCache.put("3", "3");
        myLruCache.put("4", "4");
        myLruCache.put("2", "2");
        myLruCache.put("1", "1");
        System.out.println();
    }
}