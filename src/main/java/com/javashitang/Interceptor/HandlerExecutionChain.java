package com.javashitang.Interceptor;

import java.util.ArrayList;
import java.util.List;

public class HandlerExecutionChain {

    private List<HandlerInterceptor> interceptorList = new ArrayList<>();

    public void addInterceptor(HandlerInterceptor interceptor) {
        interceptorList.add(interceptor);
    }

    public boolean applyPreHandle() {
        for (int i = 0; i < interceptorList.size(); i++) {
            HandlerInterceptor interceptor = interceptorList.get(i);
            if (!interceptor.preHandle()) {
                return false;
            }
        }
        return true;
    }
}
