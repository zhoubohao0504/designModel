package com.zbh.pattern.dbroute.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.Method;

/**
 * 原理是通过字节码重组完全生成一个新的对象并不是JDKMeipo类也不是一个Girl类
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        try {

            Object obj = new JDKMeipo().getInstance(new Girl());
            Method method = obj.getClass().getMethod("findLove",null);
            method.invoke(obj);

            //obj.findLove();

            //$Proxy0
//            byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
//            FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
//            os.write(bytes);
//            os.close();

        }catch (Exception e){
            e.printStackTrace();
        }



    }

}
