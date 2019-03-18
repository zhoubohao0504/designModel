package com.zbh.pattern.myproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.lang.Iterable;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ZProxy {
    public static final String  ln= "\r\n";

    public static Object newProxyInstance(ZClassLoader loader , Class<?>[] interfaces , ZIvokationHanle hanle){

        try{
            //1.动态生成源代码
            String src = generateSrc(interfaces);
            System.out.println(src);

            //2.通过java文件输出到磁盘
            String filePath = ZProxy.class.getResource("").getPath();
            File file = new File(filePath +"$Proxy0.java");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(src);
            fileWriter.flush();
            fileWriter.close();
            //3.对文件编译
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);//
            Iterable iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();

            Class proxClass = loader.findClass("$Proxy0");
            Constructor c =proxClass.getConstructor(ZIvokationHanle.class);
            return c.newInstance(hanle);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        //构建java代码
        StringBuffer stringBuffer = new StringBuffer();
        //包名及引入
        stringBuffer.append("package com.zbh.pattern.myproxy;"+ln);
        stringBuffer.append("import com.zbh.pattern.dbroute.Person;" + ln);
        stringBuffer.append("import com.zbh.pattern.myproxy.ZIvokationHanle;"+ln);
        stringBuffer.append("import java.lang.reflect.*;" + ln);
        //类名及实现接口
        stringBuffer.append("public class $Proxy0 implements "+interfaces[0].getName()+"{"+ln);
        stringBuffer.append("ZIvokationHanle h;"+ln);
        //构造方法
        stringBuffer.append("public $Proxy0(ZIvokationHanle h){"+ln);
        stringBuffer.append("this.h=h;"+ln);
        stringBuffer.append("}"+ln);

        for(Method m :interfaces[0].getMethods()){
            stringBuffer.append("public "+m.getReturnType().getName()+" "+m.getName()+"(){"+ln);
                stringBuffer.append("try{"+ln);
                    stringBuffer.append("Method m =" +interfaces[0].getName() +".class.getMethod(\""+m.getName()+"\",new Class[]{});"+ln);
                    stringBuffer.append("this.h.invoke(this,m,null);"+ln);
                stringBuffer.append("}catch(Throwable e){"+ln);
                stringBuffer.append("e.printStackTrace();"+ln);
                stringBuffer.append("}"+ln);
                stringBuffer.append("}"+ln);
        }
        stringBuffer.append("}"+ln);
        return  stringBuffer.toString();
    }
}
