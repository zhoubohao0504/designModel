package com.zbh.strategy.pay.payPort;

public class JDpay extends PayMent {
    public String getName() {
        return "京东白条";
    }

    protected double queryBalance(String uid) {
        return 500;
    }
}
