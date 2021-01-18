package com.javashitang.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author lilimin
 * @since 2021-01-18
 */
public class LfuCache<K, V> {

    private HashMap<K, V> keyToVal;
    private HashMap<K, Integer> keyToFreq;
    private HashMap<Integer, LinkedHashSet<K>> freqTokeys;
    int minFreq;
    int capacity;

    public V get(Object key) {
        V v = keyToVal.get(key);
        if (v == null) {
            return null;
        }
        increaseFrey(key);
        return v;
    }

    public void put(K key, V value) {
        // get方法里面会增加频次
        if (get(key) != null) {
            keyToVal.put(key, value);
            return;
        }
    }

    private void removeMinFreqKey() {

    }

    private void increaseFrey(Object k) {

    }
}
