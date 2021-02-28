package com.javashitang.spring.framework;

/**
 * @author lilimin
 * @since 2021-02-28
 */
public class BeanWrapper {

    Object wrappedObject;

    public Object getWrappedInstance() {
        return wrappedObject;
    }

    public Class<?> getWrappedClass() {
        return wrappedObject.getClass();
    }
}
