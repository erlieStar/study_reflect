package com.javashitang.classloader;

public class ClassLoaderDemo1 {

    public static void main(String[] args) {
        // null
        System.out.println(String.class.getClassLoader());
        ClassLoader loader = ClassLoaderDemo1.class.getClassLoader();
        while (loader != null) {
            // sun.misc.Launcher$AppClassLoader@58644d46
            // sun.misc.Launcher$ExtClassLoader@7ea987ac
            System.out.println(loader);
            loader = loader.getParent();
        }
    }
}
