package com.zbh.singletonPattern.lazy;

public class LazySingleton {

    private static LazySingleton lazySingleton;

    private LazySingleton(){}


    //JDK1.6之后对synchronized性能优化了不少，
    // 但是不可避免的还是存在一定的性能问题，造成所有的类有可能都被锁
    public synchronized static LazySingleton getInstance(){
        //加上空判断保证只会初始化一次，不会每次都覆盖
        //两个线程同时进入的时候就会出现线程安全问题，需要加上synchronized
        if(null == lazySingleton){
            lazySingleton= new LazySingleton();
        }
        return lazySingleton;
    }
}
