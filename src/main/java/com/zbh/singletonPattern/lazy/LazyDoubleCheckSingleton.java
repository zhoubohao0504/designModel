package com.zbh.singletonPattern.lazy;

public class LazyDoubleCheckSingleton {

    //加上volatile关键字是为了解决指令重排序的问题
    private volatile static LazyDoubleCheckSingleton lazySingleton;

    private LazyDoubleCheckSingleton() {
    }

    //适中方案
    public static LazyDoubleCheckSingleton getInstance() {
        if (null == lazySingleton) {
            //这样写避免了整个类都被锁住
            synchronized (LazyDoubleCheckSingleton.class) {
                //双重检查锁在这里再次加一个null判断
                if (null == lazySingleton) {
                    lazySingleton = new LazyDoubleCheckSingleton();
                }
            }

        }
        return lazySingleton;
    }
}
