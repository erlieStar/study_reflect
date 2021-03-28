package com.javashitang.lamada;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lilimin
 * @since 2021-03-28
 */
public class TestInterfaceTest {

    @Test
    public void doSomething() {
        TestInterface testInterface = getInterface();
        System.out.println("---");
        testInterface.doSomething();
    }

    private TestInterface getInterface() {
        return this::real;
    }

    private void real() {
        System.out.println("a");
    }
}