package com.zbh.strategy.promotion;

public class CouponStrategy implements PromotionStrategy {
    public void doPromotion() {
        System.out.println("领取优惠卷，课程价格直接减去优惠券面值抵扣");
    }
}
