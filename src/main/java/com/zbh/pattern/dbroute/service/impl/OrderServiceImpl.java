package com.zbh.pattern.dbroute.service.impl;

import com.zbh.pattern.dbroute.dao.OrderDao;
import com.zbh.pattern.dbroute.entity.Order;
import com.zbh.pattern.dbroute.service.OrderService;

public class OrderServiceImpl implements OrderService {

    private OrderDao dao;

    public OrderServiceImpl(){
        //如果使用Spring应该是自动注入的
        //我们为了使用方便，在构造方法中将orderDao直接初始化了
        dao = new OrderDao();
    }

    public int createOrder(Order order) {
        System.out.println("OrderServiceImpl调用orderDao创建订单");
        return dao.insert(order);
    }
}
