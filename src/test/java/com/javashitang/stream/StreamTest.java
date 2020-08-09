package com.javashitang.stream;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lilimin
 * @since 2020-07-13
 */
public class StreamTest {

    @Test
    public void filter() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> tempList1 = list.stream().filter(s -> {return true;}).collect(Collectors.toList());
        List<Integer> tempList2 = list.stream().filter(s -> {return false;}).collect(Collectors.toList());
        System.out.println(tempList1.size());
        System.out.println(tempList2.size());
        Assert.assertEquals(tempList1.size(), 4);
        Assert.assertEquals(tempList2.size(), 0);
    }

    @Test
    public void groupBy() {
        List<Student> studentList = Lists.newArrayList();
        Student student1 = Student.builder().name("学生1").age(10).build();
        Student student2 = Student.builder().name("学生2").age(10).build();
        Student student3 = Student.builder().name("学生3").age(20).build();
        
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        Map<Integer, List<Student>> studentMap = 
                studentList.stream().collect(Collectors.groupingBy(student -> {
                    return student.getAge();
                }));
        for (Map.Entry<Integer, List<Student>> entry : studentMap.entrySet()) {
            // 10
            // 20
            System.out.println(entry.getKey());
        }
    }

    @Test
    public void map() {
        List<Student> studentList = Lists.newArrayList();
        Student student1 = Student.builder().name("学生1").age(10).build();
        Student student2 = Student.builder().name("学生2").age(10).build();
        Student student3 = Student.builder().name("学生3").age(20).build();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        Map<String, Student> studentMap = studentList.stream().collect(Collectors.toMap(Student::getName, student -> student));
        System.out.println(studentMap);
    }
}
