package com.zbh.factory.abstractFactory;

import com.zbh.factory.*;

public class JavaFactory implements Ifactory {
    public ICourse createCouser() {
        return new JavaCourse();
    }

    public INote createNote() {
        return new JavaNote();
    }

    public IVideo createVideo() {
        return new JavaVideo();
    }
}
