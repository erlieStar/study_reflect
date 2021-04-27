package com.javashitang.bioApi;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author lilimin
 * @since 2021-04-27
 */
public class Api {

    public static void main(String[] args) throws Exception {
        String fileName = "/Users/peng/study-code/java-learning/src/main/resources/000";
        int fileSize = 1024 * 64;
        File file = new File(fileName);
        FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileSize);
        int num = buffer.getInt(10);
        System.out.println(num);
    }
}
