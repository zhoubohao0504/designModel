package com.zbh.strategy.promotion;

public class PromotionActivityTest {

    /*public static void main(String[] args) {
        PromotionActivity promotionActivity618 = new PromotionActivity(new CouponStrategy());
        promotionActivity618.execute();
        PromotionActivity promotionActivity1111 = new PromotionActivity(new CashbackStrategy());
        promotionActivity1111.execute();
    }*/

    public static void main(String[] args) {
        String promotionString ="GROUPBY";
        PromotionActivity promotionActivity = new PromotionActivity(
                PromotionStrategyFactory.getPromotionStrategy(promotionString));
        promotionActivity.execute();
    }
}
