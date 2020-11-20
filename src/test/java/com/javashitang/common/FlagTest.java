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

        // 缓行，晚点，超方，超重
        // 0 0 0 0

        // 订单的异常标签初始为0
        int extendFlag = 0;
        // 标记订单超重
        // 0 0 0 0
        // 0 0 0 1
        // 0 0 0 1
        extendFlag = EXTEND_FLAG_ENUM.addFlag(extendFlag, EXTEND_FLAG_ENUM.OVER_WEIGHT);
        // 订单确实超重了
        // 0 0 0 1
        // 0 0 0 1
        // 0 0 0 1
        assertTrue(EXTEND_FLAG_ENUM.hasFlag(extendFlag, EXTEND_FLAG_ENUM.OVER_WEIGHT));
        // 订单没有超方
        // 0 0 0 1
        // 0 0 1 0
        // 0 0 0 0
        assertFalse(EXTEND_FLAG_ENUM.hasFlag(extendFlag, EXTEND_FLAG_ENUM.OVER_CUBAGE));


        // 标记订单超方
        extendFlag = EXTEND_FLAG_ENUM.addFlag(extendFlag, EXTEND_FLAG_ENUM.OVER_CUBAGE);
        // 订单确实超重和超方了
        // 0 0 1 1
        // 0 0 0 1
        // 0 0 0 1
        assertTrue(EXTEND_FLAG_ENUM.hasFlag(extendFlag, EXTEND_FLAG_ENUM.OVER_WEIGHT));
        // 0 0 1 1
        // 0 0 1 0
        // 0 0 1 0
        assertTrue(EXTEND_FLAG_ENUM.hasFlag(extendFlag, EXTEND_FLAG_ENUM.OVER_CUBAGE));


        // 取消订单超重
        // 0 0 1 1

        // 1 1 1 0

        // 0 0 1 0
        extendFlag = EXTEND_FLAG_ENUM.removeFlag(extendFlag, EXTEND_FLAG_ENUM.OVER_WEIGHT);
        // 订单没有超重
        assertFalse(EXTEND_FLAG_ENUM.hasFlag(extendFlag, EXTEND_FLAG_ENUM.OVER_WEIGHT));
    }

    @Test
    public void showTest2() {
        // 1 1 1 1
        // 8 4 2 1

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
