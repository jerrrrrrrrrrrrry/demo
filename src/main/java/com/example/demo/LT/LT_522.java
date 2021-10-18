package com.example.demo.LT;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_522 {
    public static int checkRecord(int n) {
        int aaa = 1000000007;
        long[][][] dp = new long[2][3][n+1];
        dp[0][0][1] = 1;
        dp[1][0][1] = 1;
        dp[0][1][1] = 1;
        for (int k=2;k<=n;k++) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i==0) {
                        if (j==0){
                            dp[i][j][k] = (dp[i][j][k - 1]+dp[i][j+1][k - 1]+dp[i][j+2][k - 1])%aaa;
                        }else {
                            dp[i][j][k] = dp[i][j - 1][k - 1]%aaa;
                        }
                    }
                    if (i==1) {
                        if (j==0){
                            dp[i][j][k] =(dp[i][j][k-1]+dp[i][j+1][k-1]+dp[i][j+2][k-1]+dp[i-1][j][k-1]+dp[i-1][j+1][k-1]+dp[i-1][j+2][k-1])%aaa;
                        }else {
                            dp[i][j][k] =dp[i][j-1][k-1]%aaa;
                        }
                    }
                }
            }
        }
        long ans = (dp[0][0][n]+dp[1][0][n]+dp[0][1][n]+dp[0][2][n]+dp[1][1][n]+dp[1][2][n])%aaa;
        return (int)ans;

    }

    public static void main(String[] args) {
        checkRecord(50);
    }
}

