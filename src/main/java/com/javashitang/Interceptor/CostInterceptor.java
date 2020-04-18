package com.javashitang.Interceptor;

public class CostInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle() {
        // 这里可以针对传入的参数做一系列事情，我这里就简单返回true了;
        System.out.println("CostInterceptor 执行了");
        return true;
    }
}
