package com.javashitang.reflect;

import com.javashitang.pojo.Book;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: lilimin
 * @Date: 2020/2/20 14:47
 */
public class ReflectTest {

    /**
     * 创建对象
     */
    @Test
    public void reflectClass() throws Exception {
        Class<?> bookClass = Class.forName("com.javashitang.pojo.Book");
        Book book = (Book)bookClass.newInstance();
        book.setName("java识堂");
        book.setAuthor("小识");
        System.out.println(book);
    }

    /**
     * 通过私有构造函数创建对象
     */
    @Test
    public void reflectPrivateConstructor() throws Exception {
        Class<?> bookClass = Class.forName("com.javashitang.pojo.Book");
        Constructor<?> privateConstructor = bookClass.getDeclaredConstructor(String.class, String.class);
        privateConstructor.setAccessible(true);
        Book book = (Book)privateConstructor.newInstance("java识堂", "小识");
        System.out.println(book);
    }

    /**
     * 调用私有方法
     */
    @Test
    public void reflectPrivateMethod() throws Exception {
        Class<?> bookClass = Class.forName("com.javashitang.pojo.Book");
        Method privateMethod = bookClass.getDeclaredMethod("printTip");
        privateMethod.setAccessible(true);
        Object book = bookClass.newInstance();
        String tip = (String)privateMethod.invoke(book);
        System.out.println(tip);
    }
}
