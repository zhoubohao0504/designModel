package com.zbh.strategy.pay.payPort;

public class AliPay extends  PayMent {
    public String getName() {
        return "支付宝";
    }

    protected double queryBalance(String uid) {
        return 900;
    }
}
