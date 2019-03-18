package com.zbh.pattern.dbroute;

import com.zbh.pattern.dbroute.entity.Order;
import com.zbh.pattern.dbroute.proxy.statics.OrderServiceStaticProxy;
import com.zbh.pattern.dbroute.service.OrderService;
import com.zbh.pattern.dbroute.service.impl.OrderServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tom on 2019/3/10.
 */
public class DbRouteProxyTest {
    public static void main(String[] args) {
        try {
            Order order = new Order();

//            order.setCreateTime(new Date().getTime());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2017/02/01");
            order.setCreateTime(date.getTime());

            OrderService orderService = (OrderService)new OrderServiceStaticProxy(new OrderServiceImpl());
            orderService.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
