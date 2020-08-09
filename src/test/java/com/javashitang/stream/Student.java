package com.javashitang.stream;

import lombok.Builder;
import lombok.Data;

/**
 * @author lilimin
 * @since 2020-08-09
 */
@Data
@Builder
public class Student {
    private String name;
    private int age;
}
