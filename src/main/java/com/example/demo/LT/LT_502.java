package com.example.demo.LT;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_502 {

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[] profits1 = profits;
        profits = IntStream.range(0, capital.length)
                .boxed().sorted(Comparator.comparingInt(i -> capital[i]))
                .mapToInt(i -> profits1[i])
                .toArray();
        Arrays.sort(capital);
        int[][] dp = new int[profits.length+1][k+1];
        int ans = 0;
        for (int i=0;i<=profits.length;i++){
            dp[i][0]=w;
        }
        for (int i=1;i<=profits.length;i++){
            for (int j=1;j<=k;j++){
                dp[i][j] = dp[i-1][j];
                if (dp[i-1][j-1]>=capital[i-1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + profits[i - 1]);
                }
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        findMaximizedCapital(3,0,new int[]{1,2,3},new int[]{3,1,2});
    }
}
