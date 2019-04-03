package com.zbh.Template;

public class BigDataCourse extends NetworkCourse {

    private boolean needHomeworkFlag =false;

    public BigDataCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }

    void checkHomework() {
        System.out.println("检查大数据课程");
    }

    @Override
    protected boolean needHomeWork() {
        return this.needHomeworkFlag;
    }
}
