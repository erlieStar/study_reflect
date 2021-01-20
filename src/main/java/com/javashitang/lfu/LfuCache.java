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

    private int minFreq;
    private int capacity;

    public V get(K key) {
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
            // 重新设置值
            keyToVal.put(key, value);
            return;
        }

        // 超出容量，删除频率最低的key
        if (keyToVal.size() >= capacity) {
            removeMinFreqKey();
        }

        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        // key对应的value存在，返回存在的key
        // key对应的value不存在，添加key和value
        freqTokeys.putIfAbsent(1, new LinkedHashSet<>());
        freqTokeys.get(1).add(key);
        this.minFreq = 1;
    }

    // 删除出现频率最低的key
    private void removeMinFreqKey() {

    }

    // 增加频率
    private void increaseFrey(K key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqTokeys.get(freq).remove(key);
        freqTokeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqTokeys.get(freq + 1).add(key);
        if (freqTokeys.get(key).isEmpty()) {
            freqTokeys.remove(freq);
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }
}
