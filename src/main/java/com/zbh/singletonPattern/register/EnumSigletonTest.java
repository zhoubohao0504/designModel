package com.zbh.singletonPattern.register;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EnumSigletonTest {

    public static void main(String[] args) {
        EnumSingleTon s1 = null;
        EnumSingleTon s2 =EnumSingleTon.getInstance();
        s2.setData(new Object());
        FileOutputStream fos =null;
        try{
            //首先将SeriableSingleTon写入SeriableSingleton.obj
            fos = new FileOutputStream("EnumSingleTon.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();
            //然后再从SeriableSingleton.obj上读取，还原成SeriableSingleTon这个对象
            FileInputStream fis = new FileInputStream("EnumSingleTon.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1=(EnumSingleTon)ois.readObject();
            ois.close();
            System.out.println(s1.getData() );
            System.out.println(s2.getData() );
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}