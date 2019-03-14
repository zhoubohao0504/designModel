package com.zbh.factory.sampleFactory;


import com.zbh.factory.ICourse;

public class CourseFactory {
    /*public ICourse create(String name){
        if("java".equals(name)){
            return new JavaCourse();
        }
        return null;
    }*/

    public ICourse create(Class clazz){
        if(null != clazz){
            try {
                return (ICourse)clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
