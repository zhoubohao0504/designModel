package com.zbh.pattern.mycglib;

import net.sf.cglib.core.DebuggingClassWriter;

public class CGlibTest {

    public static void main(String[] args) {

        Customer obj = null;
        try {
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"E://cglib_proxy_classes");
            obj = (Customer) new CglibMeipo().getInstance(Customer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        obj.findLove();
    }
}
