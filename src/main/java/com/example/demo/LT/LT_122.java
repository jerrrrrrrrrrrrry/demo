package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_122 {

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length+1];
        int max = 0;
        dp[1] = 0;
        boolean status = true;
        for (int i=2;i<=prices.length;i++){
            dp[i] = dp[i-1];
            if (prices[i-1]>prices[i-2]&&status){
                dp[i] = dp[i-1]+prices[i - 1] - prices[i - 2];
                max = Math.max(max,dp[i]);
                status=false;
                continue;
            }
            status=true;
        }
        return max;
    }
}
