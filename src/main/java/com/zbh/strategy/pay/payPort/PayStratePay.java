package com.zbh.strategy.pay.payPort;

import java.util.HashMap;
import java.util.Map;

public class PayStratePay {
    public static final String ALI_PAY="AliPay";
    public static final String JD_PAY="JdPay";
    public static final String WECHAT_PAY="WeChatPay";
    public static final String UNION_PAY="UnionPay";
    public static final String DEFAULT_PAY=ALI_PAY;

    private static Map<String ,PayMent> payMentMap = new HashMap<String, PayMent>();

    static {
        payMentMap.put(ALI_PAY,new AliPay());
        payMentMap.put(JD_PAY,new JDpay());
        payMentMap.put(WECHAT_PAY,new WeiChatPay());
        payMentMap.put(UNION_PAY,new UnionPay());
    }

    public static  PayMent get(String payKey){
        if(!payMentMap.containsKey(payKey)){
            return  payMentMap.get(DEFAULT_PAY);
        }else{
            return payMentMap.get(payKey);
        }
    }
}
