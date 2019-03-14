package com.zbh.singletonPattern.lazy;

import java.lang.reflect.Constructor;

public class LazyInnerClassSingletonTest {

    public static void main(String[] args) {
        Class<?> clazz =LazyInnerClassSingleton.class;
        Constructor constructor = null;
        try {
            //通过反射强制获取其构造方法
            //破坏了单利
            constructor = clazz.getDeclaredConstructor(null);
            //强制访问
            constructor.setAccessible(true);
            Object o1 = constructor.newInstance();
            Object o2 = LazyInnerClassSingleton.getInstance();
            System.out.println(o1==o2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
