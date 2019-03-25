package com.zbh.strategy.pay.payPort;

public class WeiChatPay extends PayMent {
    public String getName() {
        return "微信支付";
    }

    protected double queryBalance(String uid) {
        return 256;
    }
}
