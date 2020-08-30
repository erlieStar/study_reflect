package com.javashitang.lambda;

import com.google.common.collect.Lists;
import com.javashitang.transfer.SchoolStudentVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaDemo {

    @Test
    public void test1() {

        // jdk1.8之前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("yes");
            }
        }).start();

        // jdk1.8及以后
        new Thread(() -> System.out.println("yes")).start();
    }

    @Data
    @AllArgsConstructor
    public class Person {
        private String name;
        private int age;
        private int salary;
    }

    List<Person> list = Arrays.asList(new Person("张三", 10, 1000),
            new Person("李四", 20, 2000),
            new Person("王五", 30, 3000));

    @Test
    public void test2() {
        System.out.println(filterByAge(list));
        System.out.println(filterBySalary(list));
    }

    public List<Person> filterByAge(List<Person> personList) {
        List<Person> resultList = Lists.newArrayList();
        for (Person person : personList) {
            if (person.getAge() > 20) {
                resultList.add(person);
            }
        }
        return resultList;
    }

    public List<Person> filterBySalary(List<Person> personList) {
        List<Person> resultList = Lists.newArrayList();
        for (Person person : personList) {
            if (person.getSalary() > 2000) {
                resultList.add(person);
            }
        }
        return resultList;
    }

    public List<Person> filter(List<Person> personList, Predicate<Person> predicate) {
        List<Person> resultList = Lists.newArrayList();
        for (Person person : personList) {
            if (predicate.test(person)) {
                resultList.add(person);
            }
        }
        return resultList;
    }

    @Test
    public void test3() {
        List<Person> filterByAgeList = filter(list, p -> p.getAge() > 20);
        List<Person> filterBySalaryList = filter(list, p -> p.getSalary() > 2000);
        System.out.println(filterByAgeList);
        System.out.println(filterBySalaryList);
    }

    @Test
    public void testCase1() {
        // 10
        consumeTask(10, (m) -> System.out.println(m));
    }

    public void consumeTask(int num, Consumer<Integer> consumer) {
        consumer.accept(num);
    }

    @Test
    public void testCase2() {
        // AAA
        System.out.println(strHandler("aaa", (str) -> str.toUpperCase()));
    }

    public String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }

}
