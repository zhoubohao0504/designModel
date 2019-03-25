package com.zbh.strategy.pay;

import com.zbh.strategy.pay.payPort.PayMent;
import com.zbh.strategy.pay.payPort.PayStratePay;

public class Order {

    private String uid;
    private String orderId;
    private Double amount;

    public MsgResult pay(String payKey){
        PayMent payMent = PayStratePay.get(payKey);
        return payMent.pay(uid,amount);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "uid='" + uid + '\'' +
                ", orderId='" + orderId + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Order(String uid, String orderId, Double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }
}
