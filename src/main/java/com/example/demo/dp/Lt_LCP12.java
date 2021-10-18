package com.example.demo.dp;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-03-24 10:50
 **/
public class Lt_LCP12 {
    public static int minTime(int[] time, int m) {
        int T = 0;
        int[][] dp = new int[m + 2][time.length + 1];
//        for (int i=0;i<time.length;i++){
//            dp[m+1][i]=time[i];
//        }
        int[] wang=new int[2];
        wang[0]=0;
        wang[1]=1;
        for (int i = m; i >= 0; i--) {
            for (int j = time.length - 1; j >= 0; j--) {
                for (int w = 0; w < wang.length; ) {
                    dp[i][j] = dp[i][j + 1];
                    if (wang[w] == 0) {
                        w = w + 1;
                    } else {
                        if ((time[j] + dp[i][j + 1]) <= 24) {
                            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1] + time[j]);
                        }
                    }
                }
            }

        }
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                T = Math.max(T, dp[i][j]);
//
//            }
//        }
        return T;
    }

    public static void main(String[] args) {
        int[] time = {1, 2, 3, 3};
        minTime(time, 2);
    }
}
