package com.javashitang.spring.framework;

/**
 * @author lilimin
 * @since 2021-02-28
 */
public interface BeanFactory {

    Object getBean(String beanName) throws Exception;

    <T> T getBean(Class<T> requiredType) throws Exception;
}
