package com.javashitang.util.guava;

import com.google.common.base.Stopwatch;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class GuavaDemoTestService {

    @Test
    public void test1() {
        // 普通Collection的创建
        List<String> list = Lists.newArrayList();
        Set<String> set = Sets.newHashSet();
        // 不变Collection的创建
        ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
        ImmutableSet<String> iSet = ImmutableSet.of("a", "b");
    }

    @Test
    public void test2() {
        Multimap<String, Integer> map = ArrayListMultimap.create();
        map.put("key1", 1);
        map.put("key1", 2);
        // [1, 2]
        System.out.println(map.get("key1"));
    }

    @Test
    public void test3() {
        Table<String, String, Integer> table = HashBasedTable.create();
        table.put("a", "a", 1);
        table.put("a", "b", 2);
        // 2
        System.out.println(table.get("a", "b"));
    }

    @Test
    public void test4() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        // do something
        long second = stopwatch.elapsed(TimeUnit.SECONDS);
    }
}