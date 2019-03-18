package com.zbh.pattern.myproxy;

import java.lang.reflect.Method;

public interface ZIvokationHanle {

    public Object invoke(Object proxy, Method method , Object[] args) throws Throwable;
}
