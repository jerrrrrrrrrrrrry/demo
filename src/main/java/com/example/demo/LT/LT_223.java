package com.example.demo.LT;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_223 {
    public int countDigitOne(int n) {
        int[] dp = new int[n+1];
        int sum = 0;
        for (int i=10;i<=n;i++){
            int a = i/10;
            int cnt = i%10==1?1:0;
            dp[i]=dp[a]+cnt;
            sum+=dp[i];
        }
        return sum;
    }

}

