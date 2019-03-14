package com.zbh.singletonPattern.lazy;

import java.io.Serializable;

public class SeriableSingleTon implements Serializable {

    public final static  SeriableSingleTon INSTANCE = new SeriableSingleTon();

    private SeriableSingleTon(){}

    public static  SeriableSingleTon getInstance(){
        return INSTANCE;
    }

    //重写readResolve方法就能解决掉单例对象序列化之后再反序列化的对象与原对象不一致的问题
    //原理：覆盖反序列化出来的对象
    //还是创建了两次，发生在JVM层面，相对来说比较安全
    //之前反序列化出来的对象会被GC回收
    private  Object readResolve(){
        return INSTANCE;
    }
}
