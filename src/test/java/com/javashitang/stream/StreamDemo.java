package com.javashitang.stream;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
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
    public void min() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        // 1
        System.out.println(list.stream().min((x, y) -> x - y).get());
    }

    @Test
    public void max() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        // 3
        System.out.println(list.stream().max((x, y) -> x - y).get());
    }

    @Test
    public void reduceCase1() {

    }

    @Test
    public void reduceCase2() {

    }

    @Data
    @AllArgsConstructor
    public class Student {
        private String name;
        private int age;
    }

    List<Student> studentList = Arrays.asList(new Student("张三", 30),
            new Student("李四", 20),
            new Student("王五", 20));

    @Test
    public void collectCase1() {
        List<String> nameList = studentList.stream().map(Student::getName).collect(Collectors.toList());
        // [张三, 李四, 王五]
        System.out.println(nameList);

        Set<Integer> ageSet = studentList.stream().map(Student::getAge).collect(Collectors.toSet());
        // [20, 30]
        System.out.println(ageSet);

        LinkedHashSet<Integer> linkedHashSet =
                studentList.stream().map(Student::getAge).collect(Collectors.toCollection(LinkedHashSet::new));
        // [30, 20]
        System.out.println(linkedHashSet);
    }


    @Test
    public void collectCase2() {
        // 总数
        long count = studentList.stream().collect(Collectors.counting());
        // 3
        System.out.println(count);

        // 平均值
        double ageAvg = studentList.stream().collect(Collectors.averagingDouble(Student::getAge));
        // 23.3
        System.out.println(ageAvg);

        // 总和
        int totalAge = studentList.stream().collect(Collectors.summingInt(Student::getAge));
        // 70
        System.out.println(totalAge);

        // 最大值
        Optional<Student> student = studentList.stream().collect(Collectors.maxBy((x, y) -> x.getAge() - y.getAge()));
        // Student(name=张三, age=30)
        System.out.println(student.get());
    }
}
