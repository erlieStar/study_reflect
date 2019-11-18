package com.javashitang.util.io;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
    }

}