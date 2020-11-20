package com.javashitang.common;

/**
 * @Author: lilimin
 * @Date: 2019/12/14 19:30
 */
public enum EXTEND_FLAG_ENUM {

    // 0001
    OVER_WEIGHT(1, "超重"),
    // 0010
    OVER_CUBAGE(1 << 1, "超方"),
    // 0100
    LATE(1 << 2, "晚点"),
    // 1000
    SLOW(1 << 3, "缓行");

    public int value;
    public String name;

    EXTEND_FLAG_ENUM(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static int addFlag(int org, EXTEND_FLAG_ENUM newFlag) {
        return org | newFlag.value;
    }

    public static int removeFlag(int org, EXTEND_FLAG_ENUM oldFlag) {
        return org & (~oldFlag.value);
    }
    public static boolean hasFlag(int org, EXTEND_FLAG_ENUM oldFlag) {
        return (org & oldFlag.value) > 0;
    }
}
