package com.zbh.factory.abstractFactory;

import com.zbh.factory.*;

public class PythonFactory implements Ifactory {
    public ICourse createCouser() {
        return new PythonCourse();
    }

    public INote createNote() {
        return new PythonNote();
    }

    public IVideo createVideo() {
        return new PythonVideo();
    }
}
