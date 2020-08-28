package com.javashitang.stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    @Test
    public void createStream() {
        // 1. Collection集合的stream()或者parallelStream()
        List<String> list = Lists.newArrayList();
        Stream<String> stream1 = list.stream();

        // 2. 调用Arrays.stream()静态方法
        Integer[] array = {1, 2, 3};
        Stream<Integer> stream2 = Arrays.stream(array);

        // 3. 调用Stream.of()静态方法
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 4. 创建无限流
        // (x) -> x + 2 为函数式接口，传入x返回x+2，0为最开始的值
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
    }

    @Test
    public void map() {
        List<String> list = Arrays.asList("a", "b", "c");
        // A B C
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
    }

    @Test
    public void flatMap() {

    }

    @Test
    public void sortedCase1() {
        List<String> list = Arrays.asList("b", "a", "c");
        // a b c
        list.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void sortedCase2() {
        List<String> list = Arrays.asList("b", "a", "c");
        // c b a
        list.stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);
    }

    @Test
    public void reduceCase1() {

    }

    @Test
    public void reduceCase2() {

    }
}
