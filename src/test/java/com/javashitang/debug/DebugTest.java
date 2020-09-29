package com.javashitang.debug;

import org.junit.Test;

/**
 * @author lilimin
 * @since 2020-09-29
 */
public class DebugTest {

    @Test
    public void condition() {
        for (int i = 0; i < 30; i++) {
            System.out.println(i);
        }
    }

    public class User {

        private String username;
        private Integer age;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    @Test
    public void changeValue() {
        User user = new User();
        user.setUsername("aa");
        System.out.println(user.getUsername() + " " + user.getAge());
    }

    @Test
    public void thread() {

        new Thread(() -> {
            System.out.println("我是线程1-1");
            System.out.println("我是线程1-2");
            System.out.println("我是线程1-3");
        }, "线程1").start();

        new Thread(() -> {
            System.out.println("我是线程2-1");
            System.out.println("我是线程2-2");
            System.out.println("我是线程2-3");
        }, "线程2").start();

        System.out.println("主线程");

    }

}
