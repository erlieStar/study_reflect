package com.javashitang.spring.framework;

/**
 * @author lilimin
 * @since 2021-02-28
 */
public interface BeanPostProcessor {

    default Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    default Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}
