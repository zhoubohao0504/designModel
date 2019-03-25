package com.zbh.delegate.simple;

import java.util.HashMap;
import java.util.Map;

public class Leader {

    //预先知道每个员工的特长特征，根据特征分发任务

    private Map<String,Employee> register = new HashMap<String,Employee>();

    public Leader(){
        register.put("加密",new EmployeeA());
        register.put("架构",new EmployeeB());
    }

    public void doing(String command){
        register.get(command).doing(command);
    }
}
