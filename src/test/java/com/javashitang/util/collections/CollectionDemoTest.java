package com.javashitang.util.collections;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class CollectionDemoTest {

    @Test
    public void test1() {
        List<String> collA = new ArrayList<>();
        List<String> collB = new ArrayList<>();
        // 判空
        CollectionUtils.isEmpty(collA);
        // 交集
        CollectionUtils.retainAll(collA, collB);
        // 并集
        CollectionUtils.union(collA, collB);
        // 差集
        CollectionUtils.subtract(collA, collB);
        // 判断相等
        CollectionUtils.isEqualCollection(collA, collB);
    }

}