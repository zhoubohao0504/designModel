package com.zbh.factory;

import com.zbh.factory.IVideo;

public class PythonVideo implements IVideo {
    public void createVideo() {
        System.out.println("正在观看python视频");
    }
}
