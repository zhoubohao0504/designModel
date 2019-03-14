package com.zbh.factory.factoryMethod;

import com.zbh.factory.ICourse;
import com.zbh.factory.JavaCourse;

public class IJavaFactory  implements ICouerseFactory{
    public ICourse create() {
        return new JavaCourse();
    }
}
