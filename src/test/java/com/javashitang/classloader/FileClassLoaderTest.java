package com.javashitang.classloader;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lilimin
 * @since 2021-07-12
 */
public class FileClassLoaderTest {


    @Test
    public void test() throws Exception {
        String rootDir = "/Users/peng/study-code/java-learning/src/main/java";
        FileClassLoader loader1 = new FileClassLoader(rootDir);
        FileClassLoader loader2 = new FileClassLoader(rootDir);

        Class class1 = loader1.findClass("com.javashitang.classloader.DemoObj");
        Class class2 = loader2.findClass("com.javashitang.classloader.DemoObj");

        // false
        System.out.println(class1 == class2);
    }

}