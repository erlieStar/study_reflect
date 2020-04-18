package com.javashitang.filter;

public class MyServlet implements Servlet {

    @Override
    public void service() {
        System.out.println("MyServlet的service方法执行了");
    }
}
