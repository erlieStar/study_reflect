package com.javashitang.util.apache.beanutils;

import com.javashitang.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class BeanUtilsDemoTestService {

    // 对属性进行赋值
    @Test
    public void test1() throws Exception{
        User user = new User();
        BeanUtils.setProperty(user, "username", "li");
        String username = BeanUtils.getProperty(user, "username");
        assertEquals("li", username);
    }

    // 对象和map进行互转
    @Test
    public void test2() throws Exception{
        User user = new User();
        user.setUsername("li");
        user.setPassword("min");
        // bean->map
        Map<String, String> map = BeanUtils.describe(user);
        assertEquals("li", map.get("username"));
        assertEquals("min", map.get("password"));
        // map->bean
        BeanUtils.populate(user, map);
    }

}