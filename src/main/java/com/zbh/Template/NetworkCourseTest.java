package com.zbh.Template;

public class NetworkCourseTest {
    public static void main(String[] args) {
        System.out.println("----java架构师课程-");
        NetworkCourse javaCourse = new JavaCourse();
        javaCourse.createCourse();
        NetworkCourse bigDataCourse = new BigDataCourse(true);
        bigDataCourse.createCourse();
    }
}
