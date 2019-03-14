package com.zbh.factory;

import com.zbh.factory.ICourse;

public class JavaCourse implements ICourse {
    public void record() {
        System.out.println("正在录制java课程");
    }
}
