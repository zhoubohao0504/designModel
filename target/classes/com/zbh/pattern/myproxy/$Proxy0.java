package com.zbh.pattern.myproxy;
import com.zbh.pattern.dbroute.Person;
import com.zbh.pattern.myproxy.ZIvokationHanle;
import java.lang.reflect.*;
public class $Proxy0 implements com.zbh.pattern.dbroute.Person{
ZIvokationHanle h;
public $Proxy0(ZIvokationHanle h){
this.h=h;
}
public void findLove(){
try{
Method m =com.zbh.pattern.dbroute.Person.class.getMethod("findLove",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){
e.printStackTrace();
}
}
}
