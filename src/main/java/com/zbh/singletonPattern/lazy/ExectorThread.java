package com.zbh.singletonPattern.lazy;

import com.zbh.singletonPattern.treadLocal.ThreadLocalSingleton;

//线程类
public class ExectorThread implements  Runnable{

    public void run() {
        //LazySingleton singleton = LazySingleton.getInstance();
        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+""+singleton);
    }
}
