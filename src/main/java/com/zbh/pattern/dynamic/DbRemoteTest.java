package com.zbh.pattern.dynamic;

import com.zbh.pattern.dbroute.entity.Order;
import com.zbh.pattern.dbroute.service.impl.OrderServiceImpl;

import java.text.SimpleDateFormat;

public class DbRemoteTest {

    public static void main(String[] args) {
        Order order = new Order();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        OrderServiceImpl orderService = (OrderServiceImpl) new OrderServiceDynamicProxy().getInstance(new OrderServiceImpl());
        orderService.createOrder(order);
    }
}
