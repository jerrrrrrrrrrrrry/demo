package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_121 {

//    public int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length+1][2];
//        dp[1][0] = 0;
//        dp[1][1] = -prices[0];
//        for (int i=2;i<=prices.length;i++){
//            dp[i][0] = Math.max(dp[i-1][1]+prices[i-1],dp[i-1][0]);
//            dp[i][1] = -Math.min(prices[i-1],-dp[i-1][1]);
//        return dp[prices.length][0];
//    }
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length+1];
        int max = 0;
        dp[1] = 0;
        for (int i=2;i<=prices.length;i++){
            if (prices[i-1]+dp[i-1]<=prices[i-2]){
                dp[i]=0;
            }else {
                dp[i] = dp[i-1]+prices[i - 1] - prices[i - 2];
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
