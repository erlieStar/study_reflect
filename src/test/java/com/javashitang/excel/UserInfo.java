package com.javashitang.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author lilimin
 * @since 2020-10-19
 */
@Data
public class UserInfo {

    @ExcelProperty(index = 0)
    private String name;

    @ExcelProperty(index = 1)
    private int age;
}
