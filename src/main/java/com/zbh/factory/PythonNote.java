package com.zbh.factory;

import com.zbh.factory.INote;

public class PythonNote implements INote {
    public void createNote() {
        System.out.println("正在记录Python笔记");
    }
}
