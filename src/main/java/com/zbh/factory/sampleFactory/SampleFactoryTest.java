package com.zbh.factory.sampleFactory;

import com.zbh.factory.ICourse;
import com.zbh.factory.JavaCourse;
import com.zbh.factory.PythonCourse;

public class SampleFactoryTest {

    public static void main(String[] args) {
        CourseFactory factory = new CourseFactory();
        ICourse course = factory.create(JavaCourse.class);
        ICourse course2 = factory.create(PythonCourse.class);
        course.record();
        course2.record();
    }
}
