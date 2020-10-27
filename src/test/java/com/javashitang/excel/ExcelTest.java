package com.javashitang.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.event.AnalysisEventListener;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author lilimin
 * @since 2020-10-19
 */
public class ExcelTest {

    @Test
    public void readExcel() throws Exception {
        InputStream inputStream = new FileInputStream("/Users/peng/study-code/java-learning/src/test/java/com/javashitang/excel/测试excel.xlsx");
        AnalysisEventListener listener = new UserInfoDataListener();
        EasyExcel.read(inputStream, UserInfo.class, listener).sheet().doRead();
    }

    @Test
    public void writeExcel() {

    }
}
