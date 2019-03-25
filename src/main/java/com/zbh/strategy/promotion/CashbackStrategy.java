package com.zbh.strategy.promotion;

public class CashbackStrategy implements PromotionStrategy {
    public void doPromotion() {
        System.out.println("返现促销，返回金额直接到支付宝账号");
    }
}
