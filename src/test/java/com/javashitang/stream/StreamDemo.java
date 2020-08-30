package com.javashitang.stream;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    @Test
    public void test1() {
        List<Integer> dataList = Arrays.asList(1, 2, 3, 4);
        // 没有输出
        dataList.stream().map(x -> {
            System.out.println(x);
            return x;});
        // 输出 1 2 3 4
        // 正常是换行，我这用空格代替了，下同
        dataList = dataList.stream().map(x -> {
            System.out.println(x);
            return x;
        }).collect(Collectors.toList());
    }

    @Test
    public void createStream() {
        // 1. Collection集合的stream()或者parallelStream()
        List<String> list = Lists.newArrayList();
        Stream<String> stream1 = list.stream();

        // 2. 调用Arrays.stream(T[] array)静态方法
        Integer[] array = {1, 2, 3};
        Stream<Integer> stream2 = Arrays.stream(array);

        // 3. 调用Stream.of(T... values)静态方法
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 4. 调用Stream.iterate(final T seed, final UnaryOperator<T> f)，创建无限流
        // (x) -> x + 2 为函数式接口，传入x返回x+2，0为最开始的值
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        // 一直输出 0 2 4 6 8 10 12 ...
        stream4.forEach(System.out::println);

        // 5. 调用调用Stream.generate()，创建无限流
        Stream<Integer> stream5 = Stream.generate(() -> 10);
        // 一直输出10，你可以用Random等类随机生成哈
        stream5.forEach(System.out::println);
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
    public void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 1 3
        list.stream().filter(x -> x % 2 == 1).forEach(System.out::println);
        // 3 4
        list.stream().skip(2).forEach(System.out::println);
    }


    @Test
    public void filter() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 1 3
        list.stream().filter(x -> x % 2 == 1).forEach(System.out::println);
    }

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // 1 3
        list.stream().filter(x -> x % 2 == 1).forEach(System.out::println);
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

        // 按照年龄分组
        // 还可以多级分组，按照年龄分组后，再按照其他条件分组，不再演示
        Map<Integer, List<Student>> listMap = studentList.stream().collect(Collectors.groupingBy(Student::getAge));
        // {20=[StreamDemo.Student(name=李四, age=20), StreamDemo.Student(name=王五, age=20)], 30=[StreamDemo.Student(name=张三, age=30)]}
        System.out.println(listMap);
    }

    @Test
    public void test11() {
        Stream<String> stream =
                Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);    // ok
        stream.noneMatch(s -> true);   // exception

    }

    @Test
    public void test5() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // false
        // 当list都为1时才会返回true
        System.out.println(list.stream().allMatch(num -> num.equals(1)));
        // true
        System.out.println(list.stream().anyMatch(num -> num.equals(1)));
        // 4
        System.out.println(list.stream().max((x, y) -> x.compareTo(y)).get());
    }

    @Test
    public void test6() {
        List<String> list = Arrays.asList("abcd", "efgh");
        // [Ljava.lang.String;@7b3300e5 [Ljava.lang.String;@2e5c649
        list.stream().map(x -> x.split("")).forEach(System.out::println);
        // a b c d e f g h
        list.stream().flatMap(x -> Arrays.stream(x.split(""))).forEach(System.out::println);
    }

    @Test
    public void test7() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int sum = list.stream().reduce(0, (x, y) -> x + y);
        // 10
        // 初始值为0，执行过程为
        // x = 0 y = 1
        // x = 1 y = 2
        // x = 3 y = 4 ...
        // 10
        System.out.println(sum);
    }
}
