package com.zbh.factory.factoryMethod;

import com.zbh.factory.ICourse;

public class FactoryMethodTest {

    public static void main(String[] args) {
        IJavaFactory javaFactory = new IJavaFactory();
        ICourse java = javaFactory.create();
        java.record();
        IPythonFactory iPythonFactory = new IPythonFactory();
        ICourse python = iPythonFactory.create();
        python.record();
    }
}
