package com.zbh.strategy.pay.payPort;

public class UnionPay extends PayMent {
    public String getName() {
        return "银联支付";
    }

    protected double queryBalance(String uid) {
        return 120;
    }
}
