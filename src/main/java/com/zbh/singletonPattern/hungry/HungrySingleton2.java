package com.zbh.singletonPattern.hungry;

public class HungrySingleton2 {

    private HungrySingleton2(){}

   private static  final HungrySingleton2 hungrySingleton;

    /**
     * 静态代码块加载
     */
    static {
        hungrySingleton= new HungrySingleton2();
    }

    public static HungrySingleton2 getInstance(){
        return hungrySingleton;
    }
}
