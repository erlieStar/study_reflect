package com.javashitang.spring.framework;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lilimin
 * @since 2021-02-28
 */
public class ApplicationContext extends DefaultListableBeanFactory implements BeanFactory {

    private String[] configLocations;
    private BeanDefinitionReader reader;

    public ApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
        try {
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void refresh() throws Exception {
        reader = new BeanDefinitionReader(this.configLocations);
        List<BeanDefinition> beanDefinitionList = reader.loadBeanDefinitions();
        doRegisterBeanDefinitions(beanDefinitionList);
        doInit();
    }

    private void doRegisterBeanDefinitions(List<BeanDefinition> beanDefinitionList) throws Exception {
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            if (beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())) {
                throw new Exception("the" + beanDefinition.getFactoryBeanName() + " is exists!");
            }
            beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
        }
    }

    private void doInit() {
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            if (!entry.getValue().isLazyInit()) {
                try {
                    getBean(beanName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 单例缓存
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>(16);
    // 通用ioc容器
    private final Map<String, BeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>(16);

    @Override
    public Object getBean(String beanName) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        Object instance = instantiateBean(beanDefinition);

        return null;
    }

    @Override
    public Object getBean(Class requiredType) throws Exception {
        return getBean(requiredType.getName());
    }

    private Object instantiateBean(BeanDefinition beanDefinition) {
        Object instance = null;
        try {
            String className = beanDefinition.getBeanClassName();
            if (factoryBeanObjectCache.containsKey(className)) {
                instance = factoryBeanObjectCache.get(className);
            } else {
                Class<?> clazz = Class.forName(className);
                factoryBeanObjectCache.put(beanDefinition.getBeanClassName(), instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}