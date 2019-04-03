package com.zbh.Template;

public abstract class NetworkCourse {

    protected final void createCourse(){
        //1.发布预习资料
        this.postPreResourse();
        //2.制作ppt
        this.createPPT();
        //3.上课
        this.live();
        //4.提交课堂笔记
        this.postNote();
        //5.提交资料
        this.postSource();
        //6.布置作业(有些课有，有些课没有)
        //如果有，就还需要检查作业这个步骤
        if(needHomeWork()){
            checkHomework();
        }
        //7
        //8.
    }

    abstract void checkHomework();

    //钩子方法
    protected boolean needHomeWork(){
        return false;
    }

    final void postSource(){
        System.out.println("提交资料");
    }

    final void postNote(){
        System.out.println("提交课件和笔记");
    }

    final void live(){
        System.out.println("在线直播");
    }

    final void createPPT(){
        System.out.println("创建PPT");
    }

    final void postPreResourse(){
        System.out.println("分发预习资料");
    }
}
