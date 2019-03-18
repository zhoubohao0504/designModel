package com.zbh.pattern.dbroute.entity;

public class DynamicDataSourceEntity {

    public  final  static String DEFAULT_SOURCE =null;

    private final static ThreadLocal<String> local = new ThreadLocal<String>();

    private DynamicDataSourceEntity(){}

    public static String get(){
        return local.get();
    }

    public static void set(String source){
        local.set(source);
    }

    public static void set(int year){local.set("DB_" + year);}

    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }
}
