package com.example.demo.dp;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-03-25 10:06
 **/
public class Dp_1048 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int t = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m + 1][2];

        for (int i = 1; i <= m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int[][] dp = new int[t + 1][m + 1];
        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= m; j++) {

                if (i - arr[j][0] >= 0) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - arr[j][0]][j - 1] + arr[j][1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        int ans = dp[t][0];
        int ans1 = dp[116][0];

        for (int i = 1; i <= m; i++) {
            if (ans < dp[t][i]) {
                ans = dp[t][i];
            }
        }
        System.out.println(ans);


    }

}
