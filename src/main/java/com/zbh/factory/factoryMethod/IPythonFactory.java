package com.zbh.factory.factoryMethod;

import com.zbh.factory.ICourse;
import com.zbh.factory.PythonCourse;

public class IPythonFactory implements ICouerseFactory {
    public ICourse create() {
        return new PythonCourse();
    }
}
