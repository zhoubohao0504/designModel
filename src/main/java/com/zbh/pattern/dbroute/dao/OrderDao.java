package com.zbh.pattern.dbroute.dao;

import com.zbh.pattern.dbroute.entity.Order;

public class OrderDao {

    public int insert(Order order){
        System.out.println("OderDao创建order成功");
        return 1;
    }
}
