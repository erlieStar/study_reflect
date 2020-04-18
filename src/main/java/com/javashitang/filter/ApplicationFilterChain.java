package com.javashitang.filter;

public class ApplicationFilterChain implements FilterChain {

    private Filter[] filters = new Filter[10];
    private Servlet servlet = null;

    // 总共的Filter数目
    private int n;

    // 当前执行完的filter数目
    private int pos;

    @Override
    public void doFilter() {
        if (pos < n) {
            Filter curFilter = filters[pos++];
            curFilter.doFilter(this);
            return;
        }
        servlet.service();
    }

    public void addFilter(Filter filter) {
        // 这里源码有动态扩容的过程，和ArrayList差不多
        // 我就不演示了，直接赋数组大小为10了
        filters[n++] = filter;
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }
}
