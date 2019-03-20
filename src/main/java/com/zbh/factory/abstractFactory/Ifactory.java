package com.zbh.factory.abstractFactory;

import com.zbh.factory.ICourse;
import com.zbh.factory.INote;
import com.zbh.factory.IVideo;

public interface Ifactory {

    ICourse createCouser();

    INote createNote();

    IVideo createVideo();
}
