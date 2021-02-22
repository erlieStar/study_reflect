package com.javashitang.cow;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lilimin
 * @since 2021-02-22
 */
public class CowTest {

    @Test
    public void cowTest() {
        List<Integer> list = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 3});
        System.out.println(list);
        Iterator it1 = list.iterator();
        list.add(4);
        System.out.println(list);
        Iterator it2 = list.iterator();
        System.out.println("---it1---");
        it1.forEachRemaining(System.out::println);
        System.out.println("---it2---");
        it2.forEachRemaining(System.out::println);
    }
}
