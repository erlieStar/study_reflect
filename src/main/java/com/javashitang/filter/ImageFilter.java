package com.javashitang.filter;

public class ImageFilter implements Filter {
    @Override
    public void doFilter(FilterChain chain) {
        System.out.println("ImageFilter执行了");
        chain.doFilter();
    }
}
