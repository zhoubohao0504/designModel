package com.zbh.delegate.simple;

public class EmployeeB implements  Employee {
    @Override
    public void doing(String command) {
        System.out.println("EmployeeB:正在架构..."+command);
    }
}
