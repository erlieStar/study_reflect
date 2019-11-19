package com.javashitang.util.apache.lang;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;

import static org.junit.Assert.*;

public class LangDemoTest {

    @Test
    public void test1() {
        // cs == null || cs.length() == 0; return true
        assertEquals(true, StringUtils.isEmpty(""));
        assertEquals(true, StringUtils.isBlank(null));
        assertEquals(true, StringUtils.isBlank(""));
        // 空格
        assertEquals(true, StringUtils.isBlank(" "));
        // 回车
        assertEquals(true, StringUtils.isBlank("    "));
    }

    @Test
    public void test2() {
        Pair<Integer, Integer> pair = new ImmutablePair<>(1, 2);
        // 1 2
        System.out.println(pair.getLeft() + " " + pair.getRight());
        Triple<Integer, Integer, Integer> triple = new ImmutableTriple<>(1,2,3);
        // 1 2 3
        System.out.println(triple.getLeft() + " " + triple.getMiddle() + " " + triple.getRight());
    }
}