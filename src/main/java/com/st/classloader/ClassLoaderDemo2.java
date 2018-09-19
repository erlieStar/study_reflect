package com.st.classloader;

public class ClassLoaderDemo2 {

    public static void main(String[] args) throws Exception {
        String rootDir="E:\\Code\\study-java\\src\\main\\java";
        FileClassLoader loader = new FileClassLoader(rootDir);
        Class<?> clazz = loader.loadClass("com.st.classloader.DemoObj");
    }
}
