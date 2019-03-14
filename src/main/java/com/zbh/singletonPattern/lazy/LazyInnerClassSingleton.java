package com.zbh.singletonPattern.lazy;

//当LazyInnerClassSingleton加载的时候会优先加载内部类
//当加载内部类的加载的时候回去加载外部类
//性能最优的一种写法
//作业：理解内部类的执行逻辑
//会被反射攻击
public class LazyInnerClassSingleton {

    //虽然构造方法私有了，但是还是能通过反射获取其构造方法
    //直接抛出异常 限制其通过反射构建
    private LazyInnerClassSingleton(){
        if(LazyHolder.lazy != null){
            throw new RuntimeException("不允许构造多个实例!");
        }
    }

    //饿汉式单利
    //LazyHolder里面的逻辑需要等到外部方法调用时才执行
    //巧妙利用的内部类的特性
    //JVM底层执行逻辑，完美的避免了县城安全性问题
    private static class LazyHolder{
        private static final  LazyInnerClassSingleton lazy =new LazyInnerClassSingleton();
    }

    public static final LazyInnerClassSingleton getInstance(){

        return LazyHolder.lazy;
    }
}
