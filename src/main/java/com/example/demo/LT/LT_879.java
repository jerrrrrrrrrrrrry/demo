package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_879 {

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int sum = 0;
        for (Integer i:profit){
            sum+=i;
        }
        int[][][] dp = new int[profit.length+1][sum+1][n+1];
        dp[0][0][0] = 1;
        for (int i=1;i<=profit.length;i++){
            for (int j=0;j<=sum;j++){
                for (int k=0;k<=n;k++){
                    if (j>=profit[i-1]&&n>=group[i-1]) {
                        dp[i][j][k] += dp[i - 1][j - profit[i - 1]][n - group[i - 1]];
                    }else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        int ans = 0;
        for (int i=minProfit;i<=sum;i++){
            for (int j=0;j<=n;j++){
                ans +=dp[profit.length][i][j];
            }
        }
        return ans;
    }

}
