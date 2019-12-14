package com.javashitang.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: lilimin
 * @Date: 2019/12/14 20:33
 */
public class FlagTest {

    @Test
    public void showTest() {
        // 订单的异常标签初始为0
        int extendFlag = 0;
        // 标记订单超重
        extendFlag = EXTEND_FLAG_ENUM.addFlag(0, EXTEND_FLAG_ENUM.OVER_WEIGHT);
        assertTrue(EXTEND_FLAG_ENUM.hasFlag(extendFlag, EXTEND_FLAG_ENUM.OVER_WEIGHT));
        // 标记订单超方
        extendFlag = EXTEND_FLAG_ENUM.addFlag(extendFlag, EXTEND_FLAG_ENUM.OVER_CUBAGE);
        // 订单确实超重和超方了
        assertTrue(EXTEND_FLAG_ENUM.hasFlag(extendFlag, EXTEND_FLAG_ENUM.OVER_WEIGHT));
        assertTrue(EXTEND_FLAG_ENUM.hasFlag(extendFlag, EXTEND_FLAG_ENUM.OVER_CUBAGE));
    }

    @Test
    public void showTest2() {
        // [1]
        System.out.println(getExtendFlag(1));
        // [1, 2, 8]
        System.out.println(getExtendFlag(11));
        // [1, 2, 4, 8]
        System.out.println(getExtendFlag(15));
    }

    public List<Integer> getExtendFlag(int num) {
        List<Integer> numList = new ArrayList<>();
        int temp = 1;
        while (temp < 16) {
            if ((num & temp) >= 1) {
                numList.add(temp);
            }
            temp = temp << 1;
        }
        return numList;
    }
}
