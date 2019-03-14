package com.zbh.singletonPattern.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//容器单例模式
public class ContainerSingleton {

    private ContainerSingleton(){}

    private static Map<String ,Object> ioc = new ConcurrentHashMap<String ,Object>();

    public static Object getBean(String className){
        if(!ioc.containsKey(className)){
            Object obj =null;
            try {
                obj =Class.forName(className).newInstance();
                ioc.put(className,obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return obj;
        }
        return ioc.get(className);
    }
}