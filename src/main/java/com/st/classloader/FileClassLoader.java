package com.st.classloader;

import java.io.*;

public class FileClassLoader extends ClassLoader {

    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String className) {

        String path = rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        String rootDir="E:\\Code\\study-java\\src\\main\\java";
        FileClassLoader loader = new FileClassLoader(rootDir);

        try {
            Class<?> clazz = loader.loadClass("com.st.classloader.DemoObj");
            // com.st.classloader.FileClassLoader@7ea987ac
            System.out.println(clazz.getClassLoader());
            // I am DemoObj
            System.out.println(clazz.newInstance().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
