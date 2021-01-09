package com.javashitang.bloomFilter;

import java.util.BitSet;

/**
 * @author lilimin
 * @since 2021-01-09
 */
public class MyBloomFilter {

    // 位数组的大小，大小为2的24次方
    private static final int DEFAULT_SIZE = 2 << 24;

    // hash函数的种子
    private static final int[] SEEDS = new int[]{3, 13, 46};

    // 位数组，数组中的元素只能是 0 或者 1
    private BitSet bits = new BitSet(DEFAULT_SIZE);

    // hash函数
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    public MyBloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    // 添加元素到位数组
    public void add(Object value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    // 判断指定元素是否存在于位数组
    public boolean contains(Object value) {
        boolean ret = true;
        for (SimpleHash f : func) {
            ret = ret && bits.get(f.hash(value));
            // hash函数有一个计算出为false，则直接返回
            if (!ret) {
                return ret;
            }
        }
        return ret;
    }

    // hash函数类
    public static class SimpleHash {

        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }

    }
}

