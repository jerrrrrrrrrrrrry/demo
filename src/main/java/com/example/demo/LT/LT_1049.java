package com.example.demo.LT;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for (Integer i:stones){
            sum+=i;
        }
        int[][] dp =new int[stones.length+1][2*sum+1];
        dp[0][sum]=1;
        for (int i=1;i<=stones.length;i++){
            for (int j=-sum;j<sum;j++){
                if (j + stones[i - 1]+sum<=2*sum) {
                    dp[i][j + sum] += dp[i - 1][j + stones[i - 1] + sum];
                }
                if (j - stones[i - 1]+sum>=0) {
                    dp[i][j + sum] += dp[i - 1][j - stones[i - 1] + sum];
                }
            }
        }

        int min=101+sum;
        for (int i=0;i<=2*sum;i++){
            if (dp[stones.length][i]>0) {
                min = Math.min(min, Math.abs(i-sum));
            }
        }
        return min;
    }
}
