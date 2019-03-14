package com.zbh.factory;

import com.zbh.factory.ICourse;

public class PythonCourse implements ICourse {
    public void record() {
        System.out.println("正在录python课程");
    }
}
