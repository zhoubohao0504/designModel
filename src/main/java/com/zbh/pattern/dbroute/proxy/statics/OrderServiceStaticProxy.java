package com.zbh.pattern.dbroute.proxy.statics;

import com.zbh.pattern.dbroute.entity.DynamicDataSourceEntity;
import com.zbh.pattern.dbroute.entity.Order;
import com.zbh.pattern.dbroute.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxy implements OrderService {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private OrderService orderService;

    public OrderServiceStaticProxy(OrderService orderService) {
        this.orderService = orderService;
    }



    public int createOrder(Order order) {
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" +  dbRouter + "】数据源处理数据" );
        DynamicDataSourceEntity.set(dbRouter);

        this.orderService.createOrder(order);
        DynamicDataSourceEntity.restore();
        return 0;
    }
}
