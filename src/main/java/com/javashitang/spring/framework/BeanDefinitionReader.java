package com.javashitang.spring.framework;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author lilimin
 * @since 2021-02-28
 */
public class BeanDefinitionReader {

    private List<String> registryBeanClass = new ArrayList<>();
    private Properties config = new Properties();
    private final String SCAN_PACKAGE = "scanPackage";

    public BeanDefinitionReader(String... locations) {
        try {
            config.load(new InputStreamReader(BeanDefinitionReader.class.getClassLoader().getResourceAsStream(locations[0]), "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        doScanner(config.getProperty(SCAN_PACKAGE));
    }

    public List<BeanDefinition> loadBeanDefinitions() {
        List<BeanDefinition> beanDefinitionList = new ArrayList<>();
        try {
            for (String className : registryBeanClass) {
                Class<?> beanClass = Class.forName(className);
                if (beanClass.isInterface()) {
                    continue;
                }
                BeanDefinition beanDefinition = doCreateBeanDefinition(beanClass.getSimpleName(), beanClass.getName())
                beanDefinitionList.add(beanDefinition);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beanDefinitionList;
    }

    // 将指定包中的类转为BeanDefinition
    private void doScanner(String scanPackage) {
        // 将包名转为实际文件路径
        URL url = BeanDefinitionReader.class.getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {

            }
        }
    }

    private BeanDefinition doCreateBeanDefinition(String beanClassName, String factoryBeanName) {
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(beanClassName);
        beanDefinition.setFactoryBeanName(factoryBeanName);
        return beanDefinition;
    }
}
