package com.zbh.strategy.pay;

import com.zbh.strategy.pay.payPort.PayStratePay;

public class PayStrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1","20190311",2222.00);

        MsgResult result = order.pay(PayStratePay.ALI_PAY);
        System.out.println(result);
    }
}
