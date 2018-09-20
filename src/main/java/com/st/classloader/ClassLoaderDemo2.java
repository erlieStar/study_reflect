package com.st.classloader;

public class ClassLoaderDemo2 {

    public static void main(String[] args) throws Exception {
        String rootDir="E:\\Code\\study-java\\src\\main\\java";
        FileClassLoader1 loader = new FileClassLoader1(rootDir);
//        FileClassLoader loader = new FileClassLoader(rootDir);
        Class<?> clazz = loader.myLoadClass("com.st.classloader.DemoObj");
//        Class<?> clazz = loader.loadClass("com.st.classloader.DemoObj");
        // com.st.classloader.FileClassLoader1@12a3a380
        System.out.println(clazz.getClassLoader());
        // sun.misc.Launcher$AppClassLoader@58644d46
        System.out.println(DemoObj.class.getClassLoader());
        Object object = clazz.newInstance();
        // I am DemoObj
        System.out.println(object);
        // false
        // 从这里可以看到，虽然class文件一样，但是由不同的classloader加载，则为不同的类
        System.out.println(object instanceof DemoObj);
    }
}
