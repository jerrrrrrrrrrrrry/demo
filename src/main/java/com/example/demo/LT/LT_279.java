package com.example.demo.LT;

import java.util.Arrays;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_279 {

    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i=1;i<=Math.sqrt(n);i++){
            for (int j=i*i;j<=n;j++){
                dp[j] = Math.min(dp[j],dp[j-i*i] +1);
            }
        }

        return dp[n];

    }

    public static void main(String[] args) {
        numSquares(10);
    }
}
