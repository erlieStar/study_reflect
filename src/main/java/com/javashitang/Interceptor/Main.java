package com.javashitang.Interceptor;

public class Main {

    public static void main(String[] args) {
        // 配置拦截器
        HandlerExecutionChain chain = new HandlerExecutionChain();
        chain.addInterceptor(new CostInterceptor());
        chain.addInterceptor(new LoginInterceptor());

        // 只有拦截器都返回true，才会调用controller的方法
        // CostInterceptor 执行了
        // LoginInterceptor 执行了
        if (!chain.applyPreHandle()) {
            return;
        }
        result();
    }

    public static void result() {
        System.out.println("这是controller的方法");
    }
}
