package com.javashitang.util.apache.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

public class IODemoTest {

    @Test
    public void test1() throws IOException {
        File file = new File("/show/data.text");
        File srcFile = new File("/show/data.text");
        File destFile = new File("/show/data.text");
        // 按行读取文件
        List<String> lines = FileUtils.readLines(file, "UTF-8");
        // 将字符串写入文件
        FileUtils.writeStringToFile(file, "test", "UTF-8");
        // 文件复制
        FileUtils.copyFile(srcFile, destFile);
    }

    @Test
    public void test2() throws IOException {
        // 拷贝流
//        IOUtils.copy(InputStream input, OutputStream output);
//        // 从流中读取内容，转为list
//        List<String> line = IOUtils.readLines(InputStream input, Charset encoding);
    }

    @Test
    public void test3() throws IOException {
    }

}