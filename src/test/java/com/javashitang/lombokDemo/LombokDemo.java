package com.javashitang.lombokDemo;

import lombok.Data;
import org.junit.Test;

/**
 * @author lilimin
 * @since 2020-10-06
 */
public class LombokDemo {


    @Data
    public class Student {
        private String name;
        private int age;
    }

    @Test
    public void test1() {

    }
}
