package com.javashitang.spring.framework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lilimin
 * @since 2021-02-28
 */
public class DefaultListableBeanFactory extends AbstractApplicationContext {

    protected final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

}
