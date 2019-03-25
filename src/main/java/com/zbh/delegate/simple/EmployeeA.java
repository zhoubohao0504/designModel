package com.zbh.delegate.simple;

public class EmployeeA implements Employee {
    @Override
    public void doing(String command) {
        System.out.println("EmployeeA：正在加密..."+command);
    }
}
