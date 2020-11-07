package com.javashitang.transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lilimin
 * @since 2020-11-07
 */
@Getter
@AllArgsConstructor
public enum GenderEnum {

    FEMALE(0, "女性"),
    MALE(1, "男性");

    private int value;
    private String name;

}
