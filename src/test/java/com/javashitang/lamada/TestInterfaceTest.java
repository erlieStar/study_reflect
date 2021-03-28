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
        // doSomething
        // real
        TestInterface testInterface = getInterface();
        System.out.println("doSomething");
        testInterface.doSomething();
    }

    private TestInterface getInterface() {
        return this::real;
    }

    private void real() {
        System.out.println("real");
    }
}