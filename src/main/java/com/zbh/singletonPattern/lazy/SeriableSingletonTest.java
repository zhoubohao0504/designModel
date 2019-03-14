package com.zbh.singletonPattern.lazy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SeriableSingletonTest {
    public static void main(String[] args) {
        SeriableSingleTon s1 = null;
        SeriableSingleTon s2 =SeriableSingleTon.getInstance();

        FileOutputStream fos =null;
        try{
            //首先将SeriableSingleTon写入SeriableSingleton.obj
            fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();
            //然后再从SeriableSingleton.obj上读取，还原成SeriableSingleTon这个对象
            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1=(SeriableSingleTon)ois.readObject();
            System.out.println(s1 );
            System.out.println(s2 );
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
