package com.zbh.strategy.promotion;

public class GroupbyStrategy implements  PromotionStrategy {
    public void doPromotion() {
        System.out.println("拼团，满20人成团，全团享受团购价格");
    }
}
