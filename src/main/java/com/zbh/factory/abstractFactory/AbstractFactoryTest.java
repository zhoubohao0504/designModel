package com.zbh.factory.abstractFactory;

import com.zbh.factory.ICourse;
import com.zbh.factory.INote;
import com.zbh.factory.IVideo;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        JavaFactory javaFactory = new JavaFactory();
        ICourse course=javaFactory.createCouser();
        IVideo video = javaFactory.createVideo();
        INote note = javaFactory.createNote();
        course.record();
        video.createVideo();
        note.createNote();
        PythonFactory pythonFactory = new PythonFactory();
        ICourse pythonCourse = pythonFactory.createCouser();
        INote pythonNote = pythonFactory.createNote();
        IVideo pythonVideo = pythonFactory.createVideo();
        pythonCourse.record();
        pythonNote.createNote();
        pythonVideo.createVideo();
    }
}
