package com.javashitang.filter;

public class Main {

    public static void main(String[] args) {
        // 在tomcat源码中，会将一个请求封装为一个ApplicationFilterChain对象
        // 然后执行ApplicationFilterChain的doFilter方法
        ApplicationFilterChain applicationFilterChain = new ApplicationFilterChain();
        applicationFilterChain.addFilter(new LogFilter());
        applicationFilterChain.addFilter(new ImageFilter());
        applicationFilterChain.setServlet(new MyServlet());

        // LogFilter执行了
        // ImageFilter执行了
        // MyServlet的service方法执行了
        applicationFilterChain.doFilter();
    }
}
