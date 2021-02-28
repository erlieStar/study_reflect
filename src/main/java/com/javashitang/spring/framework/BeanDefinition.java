package com.javashitang.spring.framework;

import lombok.Data;

/**
 * @author lilimin
 * @since 2021-02-28
 */
@Data
public class BeanDefinition {

    // bean的全类名
    private String beanClassName;
    // 是否延迟加载
    private boolean lazyInit;
    // 保存beanName，在ioc容器中存储的key
    private String factoryBeanName;
}
