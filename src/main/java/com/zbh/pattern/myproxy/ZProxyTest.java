package com.zbh.pattern.myproxy;

import com.zbh.pattern.dbroute.Person;

public class ZProxyTest {
    public static void main(String[] args) throws Exception {

        Person obj = (Person) new ZMeiPo().getInstance(new Girl());
        obj.findLove();

    }
}
