package com.javashitang.idea;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.Data;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

/**
 * @author lilimin
 * @since 2020-11-13
 */
public class ShortcutKey {

    @Data
    public class Sutdent {
        private String name;
        private int age;
    }

    // 自动导入包和去除包
    // 和查看快捷键
    @Test
    public void test0() {
    }


    // if 和 for 相关
    @Test
    public void test1() {
        boolean flag = true;
        // flag.if
//        if (flag) {
//
//        }
        // flag.else
//        if (!flag) {
//
//        }
        // flag.while
//        while (flag) {
//
//        }
        String name = "aa";
        // name.null
//        if (name == null) {
//
//        }
        // name.nn
//        if (name != null) {
//
//        }
        List<String> list = Lists.newArrayList();
        // list.fori
//        for (int i = 0; i < list.size(); i++) {
//
//        }
        // list.forr
//        for (int i = list.size() - 1; i >= 0; i--) {
//
//        }
        // list.for
//        for (String s : list) {
//
//        }
    }


    // 快速返回，快速输出
    @Test
    public Integer test2() {
        int a = 10;
        // a.return
        System.out.println(a);
        System.out.println(a);
        return a;
    }


    // 快速写异常
    @Test
    public void test3() {
        // .try
        try {
            int a = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 使用var直接返回值
    @Test
    public void test4() {
        // test5().var
        List<Integer> list = test5();
        // Sets.newHashSet().var
        HashSet<Object> objects = Sets.newHashSet();
    }

    @Test
    public List<Integer> test5() {
        return Lists.newArrayList();
    }

}
