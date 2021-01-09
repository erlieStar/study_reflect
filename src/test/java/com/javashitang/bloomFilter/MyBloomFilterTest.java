package com.javashitang.bloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

/**
 * @author lilimin
 * @since 2021-01-09
 */
public class MyBloomFilterTest {


    @Test
    public void myBloomFilter() {
        Integer value1 = 13423;
        Integer value2 = 22131;
        MyBloomFilter filter = new MyBloomFilter();
        // false
        System.out.println(filter.contains(value1));
        // false
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        // true
        System.out.println(filter.contains(value1));
        // true
        System.out.println(filter.contains(value2));
    }

    @Test
    public void googleGuave() {
        // 创建布隆过滤器对象，最多元素数量为500，期望误报概率为0.01
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(), 500, 0.01);
        // 判断指定元素是否存在
        // false
        System.out.println(filter.mightContain(1));
        // false
        System.out.println(filter.mightContain(2));
        // 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        // true
        System.out.println(filter.mightContain(1));
        // true
        System.out.println(filter.mightContain(2));

    }
}