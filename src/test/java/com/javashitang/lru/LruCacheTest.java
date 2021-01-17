package com.javashitang.lru;

import org.junit.Test;

/**
 * @author lilimin
 * @since 2021-01-17
 */
public class LruCacheTest {

    @Test
    public void removeEldestEntry() {

        LruCache<String, String> lruCache = new LruCache(3);
        lruCache.put("1", "1");
        lruCache.put("2", "2");
        lruCache.put("3", "3");
        lruCache.put("4", "4");
        System.out.println(lruCache);
    }
}