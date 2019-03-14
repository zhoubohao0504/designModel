package com.zbh.singletonPattern.register;

/**
 * 枚举单例
 * 从jdk底层去优化
 */
public enum  EnumSingleTon {

    INSTANCE;

    private Object data;


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static  EnumSingleTon getInstance(){
        return INSTANCE;
    }

}
