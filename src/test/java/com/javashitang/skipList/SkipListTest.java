package com.javashitang.skipList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lilimin
 * @since 2021-01-02
 */
public class SkipListTest {

    SkipList skipList = new SkipList();

    @Before
    public void init() {
        skipList.insert(22);
        skipList.insert(19);
        skipList.insert(7);
        skipList.insert(3);
        skipList.insert(37);
        skipList.insert(11);
        skipList.insert(26);
    }

    @Test
    public void find() {
        SkipList.Node node = skipList.find(22);
        System.out.println(node);
    }

    @Test
    public void insert() {

    }

    @Test
    public void delete() {
        skipList.delete(22);
    }


}